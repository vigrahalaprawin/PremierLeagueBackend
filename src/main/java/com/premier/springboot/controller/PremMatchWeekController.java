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
	
	@GetMapping("/matchWeekResults/{teamName}") //Getting individual team Results form matchWeek
	public List<PremMatchWeek> getIndividualTeamResults(@PathVariable String teamName){
		return premMatchWeekService.individualMatchResult(teamName);
	}
	
	

	@DeleteMapping("/matchWeek/{matchWeek_id}") //delete  with  Id
	public List<PremMatchWeek> deleteMatchWeek(@PathVariable String matchWeek_id){
			premMatchWeekService.deleteSingleMatchWeek(matchWeek_id);
			return allMatches();
	}
	
	@PutMapping("/matchWeek/{matchWeek_id}") //Editing the data for the matchWeek info
	public PremMatchWeek updateMatchWeek(@PathVariable String matchWeek_id,@RequestBody PremMatchWeek premMatchWeek){			
		return premMatchWeekService.updateMatchWeek(matchWeek_id, premMatchWeek);
	}
	
	@GetMapping("/matchWeekMatchId/{matchId}")   //Getting information of MatchWeek Info to display table wise 
	public ResponseEntity<List<PremMatchWeek>> getResultsByMatchWeek(@PathVariable String matchId) {		
		return ResponseEntity.ok(premMatchWeekService.getAllByMatchWeekId(matchId));
	}
	
	@GetMapping("/matchWeekMatchId/teamNames/{matchId}") //Getting teamNames which are updated already for the add matchweek option
	public List<String> getTeamNamesSelectedonMatchWeek(@PathVariable String matchId){
		return  premMatchWeekService.teamNamesSelectedonMatchWeek(matchId);
	}
	
	@GetMapping("/matchWeekIds")  //Getting matchWeekIds till now updated 
	public List<Integer> getMatchWeekIds(){
		return  premMatchWeekService.getAllMatchWeekDays();
	}
}
