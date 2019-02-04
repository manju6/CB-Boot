package com.team.curingmachine.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.curingmachine.model.TrainingSet;
import com.team.curingmachine.repo.TrainingSetRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestAPIController {
	
	@Autowired
	TrainingSetRepository repo;
	
	@GetMapping("/all")
	public List<TrainingSet> findAll()  
	{
			List<TrainingSet> teamDetails  = new ArrayList<>();
		    repo.findAll().forEach(teamDetails::add);
		    return  teamDetails ;
	}
		
	@PostMapping("/trainingSet")
	public int registerStudentForCourse(@RequestBody List<TrainingSet> data) {

		System.out.println(data);
		repo.saveAll(data);
		return 1;
	}
	
	@PostMapping("/team")
	public List<TrainingSet> team()  
	{
			//@RequestBody List<String> teams
		
			List<String> teams = new ArrayList<>();
			teams.add("Sample");
			teams.add("Devops");			
		
			List<TrainingSet> teamDetails  = new ArrayList<>();
			
		    repo.findDistinctByTeamsIn(teams).forEach(teamDetails::add);
		    
		    return  teamDetails ;
	}

	

	
	
	

}
	


	





