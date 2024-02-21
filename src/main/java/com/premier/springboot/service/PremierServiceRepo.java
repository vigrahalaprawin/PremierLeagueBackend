package com.premier.springboot.service;

import org.springframework.http.ResponseEntity;


import com.premier.springboot.model.PremierLeague;


public interface PremierServiceRepo {
	
	ResponseEntity<PremierLeague> updatePremTeam(String id,PremierLeague premLeague);

}
