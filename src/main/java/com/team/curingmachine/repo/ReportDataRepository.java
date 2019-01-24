package com.team.curingmachine.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.team.curingmachine.model.ReportData;

@Transactional
public interface ReportDataRepository extends MongoRepository<ReportData, String>
{

	List<ReportData> findFirst200ByOrderByIdDesc();
	List<ReportData> findFirst1ByOrderByIdDesc();

	List<ReportData> findByIdAfterOrderByIdAsc(Date start);
	
}
