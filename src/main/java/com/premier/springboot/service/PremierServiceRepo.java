package com.premier.springboot.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.premier.springboot.model.PremierLeague;


public interface PremierServiceRepo {
	
	ResponseEntity<PremierLeague> updatePremTeam(String id,PremierLeague premLeague);
	
	List<PremierLeague> showPremTeamWithIds();

}
