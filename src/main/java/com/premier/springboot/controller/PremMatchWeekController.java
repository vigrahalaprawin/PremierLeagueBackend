package com.premier.springboot.controller;

import java.util.List;

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
import com.premier.springboot.model.PremMatchWeek;

import com.premier.springboot.service.PremMatchWeekService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PremMatchWeekController {
	
	@Autowired
	PremMatchWeekService premMatchWeekService;
		
	@PostMapping("/addMatchWeek")
	public PremMatchWeek createMatchWeek(@RequestBody PremMatchWeek premMatchWeek) {
		return premMatchWeekService.matchweekAdd(premMatchWeek);
	}
	
	@GetMapping("/allMatchWeek")
	public List<PremMatchWeek> allMatches(){
		return premMatchWeekService.allMatches();
	}
	
	@GetMapping("/teamResults/{teamName}")
	public List<PremMatchWeek> getIndividualTeamResults(@PathVariable String teamName){
		return premMatchWeekService.individualMatchResult(teamName);
	}
	
	

	@DeleteMapping("/MatchWeek/{matchWeek_id}")
	public List<PremMatchWeek> deleteMatchWeek(@PathVariable String matchWeek_id){
			premMatchWeekService.deleteSingleMatchWeek(matchWeek_id);
			return premMatchWeekService.allMatches();
	}
	
	@PutMapping("/MatchWeek/{matchWeek_id}")
	public PremMatchWeek updateMatchWeek(@PathVariable String matchWeek_id,@RequestBody PremMatchWeek premMatchWeek){			
		return premMatchWeekService.updateMatchWeek(matchWeek_id, premMatchWeek);
	}
	
	@GetMapping("/teamResultsMatchWeek/{matchId}")
	public ResponseEntity<List<PremMatchWeek>> getResultsByMatchWeek(@PathVariable String matchId) {		
		List<PremMatchWeek>  resultData = premMatchWeekService.getAllByMatchWeekId(matchId);
		return ResponseEntity.ok(resultData);
	}

	
//	@GetMapping("/teamSorting/{teamName}")
//	public List<String> getSortedNames(@PathVariable String teamName){
//		return premMatchWeekService.
//	}
//	
	
}
