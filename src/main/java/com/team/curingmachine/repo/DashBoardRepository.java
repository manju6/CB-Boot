package com.team.curingmachine.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.team.curingmachine.model.Parms;

@Transactional
public interface DashBoardRepository extends MongoRepository<Parms, String>
{
	List<Parms> findByMachineNo(int no);
	List<Parms> findByMachineName(String name);
	List<Parms> findByMachineNameAndIdBetweenOrderByIdDesc(String name,Date start, Date end);
	List<Parms> findByMachineNameAndIdBetweenOrderByIdAsc(String name,Date start, Date end);

	List<Parms> findByMachineNameAllIgnoreCaseAndIdAfterOrderByIdAsc(String name,Date start);
	List<Parms> findMachineNameDistinctBy();
	
}
