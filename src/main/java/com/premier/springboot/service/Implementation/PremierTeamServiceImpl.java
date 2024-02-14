package com.premier.springboot.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.premier.springboot.repository.PremierRepository;

public class PremierTeamServiceImpl {
	
	@Autowired
	PremierRepository premierRepository;
	
	public List<String> getAllPremierTeams(){
		  return premierRepository.allPremierTeams();
		
	}
	

}
