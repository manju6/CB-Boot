package com.team.curingmachine.repo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import com.team.curingmachine.model.Parms;
import com.team.curingmachine.model.ReportData;


@Repository
public class DashBoardRepositoryImpl 
{
	
	@Autowired
	MongoTemplate mongoTemplate;
	

// =================NON UI API CALLS=======================// 
		public <T> List<?> getAllChartsData() 
		{
			Aggregation agg = newAggregation(
					sort(Sort.Direction.DESC, "machineName"),
					group("machineName").
					push("$$ROOT").as("dashBoardData").
								push(new BasicDBObject
			                    ("id", "$_id").append
			                    ("productionCount", "$productioncount").append
			                    ("internalPressure", "$internalpressure")).as("dashBoardData")
				);
			AggregationResults<DBObject> groupResults 	= mongoTemplate.aggregate(agg,Parms.class,DBObject.class);
			List<DBObject> result = groupResults.getMappedResults();
			return result;
		}
		
		public <T> List<?> getAllMachineData() 
		{
			Aggregation agg = newAggregation(
					sort(Sort.Direction.DESC, "machineName"),
					group("machineName").
					push("$$ROOT").as("dashBoardData"));
			AggregationResults<DBObject> groupResults 	= mongoTemplate.aggregate(agg,Parms.class,DBObject.class);
			List<DBObject> result = groupResults.getMappedResults();
			return result;
		}

// =================UI API CALLS=======================// 
		
		public <T> List<?> getCurrentMachineData() 
		{

			Aggregation agg = newAggregation(
					sort(Sort.Direction.DESC, "id"),
					group("machineName").push("$$ROOT").as("dashBoardData"),
					project().and("dashBoardData").slice(1).as("currentData")			
					);
			AggregationResults<DBObject> groupResults 	= mongoTemplate.aggregate(agg,Parms.class,DBObject.class);
			List<DBObject> result = groupResults.getMappedResults();
			return result;
	
		}
		
		public <T> List<?> getChartsDataWithStartAndEndTS(Date startDate,Date endDate) 
		{
			Aggregation agg = newAggregation(
					sort(Sort.Direction.ASC, "id"),
					match(Criteria.where("id").lte(endDate).gt(startDate)),
					group("machineName").
								push(new BasicDBObject
			                    ("id", "$_id").append
			                    ("productionCount", "$productioncount").append
			                    ("internalPressure", "$internalpressure")).as("dashBoardData")
				);
			AggregationResults<DBObject> groupResults 	= mongoTemplate.aggregate(agg,Parms.class,DBObject.class);
			List<DBObject> result = groupResults.getMappedResults();
			return result;

		}

		public List<?> getMachineLocationData(Date startDate,Date endDate) 
		{
			List<ReportData> resultSet = new ArrayList<>();
			Query query = new Query(Criteria.where("id").lte(endDate).gt(startDate)).with(new Sort(Sort.Direction.ASC, "id"));
			resultSet = mongoTemplate.find(query, ReportData.class);
			return resultSet;
		}
	

	}
