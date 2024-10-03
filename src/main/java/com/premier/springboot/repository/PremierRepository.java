package com.premier.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.premier.springboot.model.PremierLeague;


@Repository
public interface PremierRepository  extends JpaRepository<PremierLeague, Long>   {


	
	 @Query(value = "select team_name from premier",nativeQuery=true)
	 List<String>   allPremierTeams();
	
	 @Query(value = "select id,team_name from premier",nativeQuery=true)
	 List<Object[]>   showAllPremierTeamsWithId();
	
	 
}
