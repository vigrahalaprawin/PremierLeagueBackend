package com.premier.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.premier.springboot.model.PremierLeague;

public interface PremierRepository  extends JpaRepository<PremierLeague, Long>   {

	void deleteById(Long id);
	
	 @Query(value = "select team_name from premier",nativeQuery=true)
	 List<String>   allPremierTeams();

}
