package com.team.curingmachine.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.team.curingmachine.model.TrainingSet;


@Transactional
public interface ProcessTrainingSetRepository extends MongoRepository<TrainingSet, String>
{
	
	
}
