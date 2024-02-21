package com.premier.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premier.springboot.exception.ResourceNotFoundException;
import com.premier.springboot.model.PremMatchWeek;
import com.premier.springboot.model.PremierLeague;
import com.premier.springboot.repository.PremMatchWeekRepository;
import com.premier.springboot.repository.PremierRepository;
import com.premier.springboot.service.PremierServiceRepo;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class PremierController {
	
	@Autowired
	private PremierRepository premierRepository;
	
	@Autowired
	private PremMatchWeekRepository premMatchWeek;
	
	@Autowired
	private PremierServiceRepo premierServiceRepo;

	
	
	@RequestMapping("/")
	public String homePage() {
		return " We are in the PremierController home page ";
	}
	
	
	@GetMapping("/teams")
	public List<PremierLeague> getAllTeams(){
		return  premierRepository.findAll();		
	}
	
	@PostMapping("/addTeam")
	public PremierLeague createTeam(@RequestBody PremierLeague premierLeageue) {
		return premierRepository.save(premierLeageue);
		
	}
	
	//get Team by Id 
	@GetMapping("/premTeam/{id}")
	public ResponseEntity<PremierLeague> getPremTeamWithId(@PathVariable Long id) {		
		PremierLeague premierLeague = premierRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Prem team not exist"));
		return ResponseEntity.ok(premierLeague);
		
	}
	
	//update Team by  id 
	
	@PutMapping("/updateTeam/{id}")
	public ResponseEntity<PremierLeague> updatePremTeam(@PathVariable String id,
			@RequestBody PremierLeague premLeague){
		
		  return premierServiceRepo.updatePremTeam(id, premLeague);
		
	}
	
	@DeleteMapping("/deleteTeam/{id}")
	public List<PremierLeague> deletePremTeam(@PathVariable String id){		
		premierRepository.deleteById(Long.parseLong(id));
		return premierRepository.findAll();
		
	}
  
	
	@GetMapping("/searchTeam/{teamName}")
	public List<PremMatchWeek> getSearchedTeams(@PathVariable String teamName){
		return premMatchWeek.findAllSortedByteamName(teamName);
	}
	
	@GetMapping("/premierTeams")
	public List<String> getAllPremierTeams() {
	   return premierRepository.allPremierTeams();
	  
	}
	

}
