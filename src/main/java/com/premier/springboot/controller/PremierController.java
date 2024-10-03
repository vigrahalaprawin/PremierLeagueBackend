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


import com.premier.springboot.model.PremierLeague;

import com.premier.springboot.repository.PremierRepository;
import com.premier.springboot.service.PremierServiceRepo;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class PremierController {
	
	@Autowired
	PremierRepository premierRepository; //Calling JPA induced PremierLeague 
	
	@Autowired
	PremierServiceRepo premierServiceRepo;

	
	
	@RequestMapping("/")
	public String homePage() {
		return " We are in the PremierController home page ";
	}  
	
	@GetMapping("/teams")
	public ResponseEntity<List<PremierLeague>> getAllTeams(){
		return  ResponseEntity.ok(premierServiceRepo.getAllTeamsInfo());		
	}
	
	@PostMapping("/addTeam")
	public PremierLeague createTeam(@RequestBody PremierLeague premierLeageue) {
		return premierRepository.save(premierLeageue);	
	}
	
	@GetMapping("/premTeam/{id}")  //get Team by Id 
	public ResponseEntity<PremierLeague> getPremTeamWithId(@PathVariable Long id) {		
		PremierLeague premierLeague = premierRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Prem team not exist"));
		return ResponseEntity.ok(premierLeague);
		
	}
	
	@PutMapping("/updateTeam/{id}")  //update Team by  id 
	public ResponseEntity<PremierLeague> updatePremTeam(@PathVariable String id,
			@RequestBody PremierLeague premLeague){
		  return premierServiceRepo.updatePremTeam(id, premLeague);	
	}
	
	@DeleteMapping("/deleteTeam/{id}")
	public List<PremierLeague> deletePremTeam(@PathVariable String id){		
		premierServiceRepo.deleteByIdFromTable(id);
		return premierRepository.findAll();	
	}
  
	@GetMapping("/premierTeams")
	public List<String> getAllPremierTeams() {
		return premierServiceRepo.getAllPremierTeamNames();
	}
	
	@GetMapping("/premierTeamsWithId")  //Not Implemented in FrontEnd coded for future purpose if any
	public List<PremierLeague> getAllPremierTeamsWithId() {
	   return  premierServiceRepo.showPremTeamWithIds();
	  
	}
	

}
