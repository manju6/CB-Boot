package com.team.curingmachine.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.curingmachine.model.Parms;
import com.team.curingmachine.model.ReportData;
import com.team.curingmachine.model.TrainingSet;
import com.team.curingmachine.repo.DashBoardRepository;
import com.team.curingmachine.repo.DashBoardRepositoryImpl;
import com.team.curingmachine.repo.ProcessTrainingSetRepository;
import com.team.curingmachine.repo.ReportDataRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestAPIController {

	@Autowired
	DashBoardRepository repository;
	
	@Autowired
	ReportDataRepository reportDataRepository;
	
	@Autowired
	DashBoardRepositoryImpl repositoryImpl;
	
	@Autowired
	ProcessTrainingSetRepository repo;
	
	@GetMapping("/all")
	public List<TrainingSet> findAll()  
	{
		   List<TrainingSet> teamDetails  = new ArrayList<>();
		   repo.findAll().forEach(teamDetails::add);			
		   return  teamDetails ;
	}
	
//	@GetMapping("/team")
//	public List<ProcessTrainingSetRepository>  findbyTeam()  
//	{
//		List<ProcessTrainingSetRepository> machineDetails = repo.findbyTeam("Sample");
//		return machineDetails;
//	}
	
	// =================NON UI API CALLS=======================//
	
	@GetMapping("/machine/allData")
	public List<Parms> getAllData() 
	{
		// select all datas in dashBoard collection 
		List<Parms> machineDetails  = new ArrayList<>();
		repository.findAll().forEach(machineDetails::add);
		return machineDetails;
	}
	
	@GetMapping("/machineNo/{no}")
	public List<Parms> findByMachineNo(@PathVariable int no) {
		// select all datas in dashBoard collection for given MachineNo
		List<Parms> machineDetails = repository.findByMachineNo(no);
		return machineDetails;
	}
	
	@GetMapping("/machineName/{name}")
	public List<Parms> findByMachineName(@PathVariable String name) {
		// select all datas in dashBoard collection for given MachineName
		List<Parms> machineDetails = repository.findByMachineName("Curing Machine "+name);
		return machineDetails;
	}
	
	@GetMapping("/machine/all/data")
	public List<?>  getAllMachineData() {
		// select all datas in dashBoard collection and groupBy MachineName
		return repositoryImpl.getAllMachineData();
	}
	
	@GetMapping("/machine/all/chartsData")
	public List<?>  getChartsData() {
		// select all timestamp:productionCount,internalPressure in dashBoard collection and groupBy MachineName
		return repositoryImpl.getAllChartsData();
	}
	
	@GetMapping("/machine/current/data")
	public List<?>  getCurrentMachineData() {
		// select current data's in dashBoard collection and groupBy MachineName
		return repositoryImpl.getCurrentMachineData();
	}
	
	@GetMapping("/machine/current/chartsData")
	public List<?> getChartsDataWithStartAndEndTS(
			@RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) 
	{
		// select given timestamp:productionCount,internalPressure in dashBoard collection and groupBy MachineName
		 List<?> machineDetails = repositoryImpl.getChartsDataWithStartAndEndTS(startDate,endDate);
		return machineDetails;
	}

	@GetMapping("/{machineLocation}/data")
	public List<?> getMachineLocationData(
			@RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) 
	{
		// select given timestamp:productionCount,internalPressure in dashBoard collection and groupBy MachineName
		 List<?> machineDetails = repositoryImpl.getMachineLocationData(startDate,endDate);
		return machineDetails;
	}
		
	@GetMapping("/machineName/current/{name}")
	public List<Parms> findByMachineNameIdBetween(@PathVariable String name,
			@RequestParam(value = "startDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam(value = "endDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate)  
	{
			// select all datas in dashBoard collection for given MachineName
			List<Parms> machineDetails = repository.findByMachineNameAndIdBetweenOrderByIdAsc("Curing Machine "+name,startDate,endDate);
			return machineDetails;
			//return null;
	}
	
	@GetMapping("/globalData/current")
	public List<ReportData> findFirst1ByOrderByIdDesc()  
	{
			// select all datas in dashBoard collection for given MachineName
			List<ReportData> machineDetails = reportDataRepository.findFirst1ByOrderByIdDesc();
			return  machineDetails ;
	}
	
	@GetMapping("/machine/distinctCount")
	public List<Parms>  findDistinctMachineName()  
	{
			// select distinct machine in the store
		   List<Parms>  machineDetails = repository.findMachineNameDistinctBy();
		   return  machineDetails ;
	}
	
	@GetMapping("/globalData/200")
	public List<ReportData> findFirst200ByOrderByIdDesc()  
	{
			// select all datas in dashBoard collection for given MachineName
			List<ReportData> machineDetails = reportDataRepository.findFirst200ByOrderByIdDesc();
			Collections.reverse(machineDetails);
			return  machineDetails ;

	}
	
	// =================UI API CALLS=======================//
	
	@GetMapping("/machineName/data/{name}")
	public List<Parms> findByMachineNameIdBetween(@PathVariable String name)  
	{
			Date startDate = new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1000));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			dateFormat.format(startDate);
			List<Parms> machineDetails = repository.findByMachineNameAllIgnoreCaseAndIdAfterOrderByIdAsc("Curing Machine "+name,startDate);
			return machineDetails;
	}
	
	@GetMapping("/globalData")
	public List<ReportData> findLastHourData()  
	{
			Date startDate = new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1000));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			dateFormat.format(startDate);
			List<ReportData> machineDetails = reportDataRepository.findByIdAfterOrderByIdAsc(startDate);
			return machineDetails;
	}
	

}
	


	





