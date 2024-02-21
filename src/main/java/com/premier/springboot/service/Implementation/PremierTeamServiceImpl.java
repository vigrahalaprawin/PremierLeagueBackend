package com.premier.springboot.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.premier.springboot.exception.ResourceNotFoundException;
import com.premier.springboot.model.PremierLeague;
import com.premier.springboot.repository.PremierRepository;
import com.premier.springboot.service.PremierServiceRepo;

@Service
public class PremierTeamServiceImpl implements PremierServiceRepo {
	
	@Autowired
	PremierRepository premierRepository;
	
	public List<String> getAllPremierTeams(){
		  return premierRepository.allPremierTeams();
		
	}
	
	
	public ResponseEntity<PremierLeague> updatePremTeam(String id,PremierLeague premLeague) {
		
		PremierLeague premierLeague = premierRepository.findById(Long.parseLong(id)).orElseThrow(
				()-> new ResourceNotFoundException("Prem team not exist"));
		premierLeague.setTeamName(premLeague.getTeamName());
		premierLeague.setTeamCoach(premLeague.getTeamCoach());
		premierLeague.setTeamStadium(premLeague.getTeamStadium());	
		PremierLeague updatedTeam = premierRepository.save(premierLeague);
		return ResponseEntity.ok(updatedTeam);
		
	}


}