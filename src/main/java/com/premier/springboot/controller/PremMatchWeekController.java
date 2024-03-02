package com.premier.springboot.controller;

import java.util.Collections;
import java.util.Comparator;
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
import com.premier.springboot.model.PremierLeague;
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
		List<PremMatchWeek> sortedList = premMatchWeekService.allMatches();
		sortedList.sort(Comparator.comparing(PremMatchWeek::getMatchWeek));	
		return sortedList;
	}
	
	@GetMapping("/matchWeekResults/{teamName}")
	public List<PremMatchWeek> getIndividualTeamResults(@PathVariable String teamName){
		List<PremMatchWeek> sortedList = premMatchWeekService.individualMatchResult(teamName);
		sortedList.sort(Comparator.comparing(PremMatchWeek::getMatchWeek));
		return sortedList;
	}
	
	

	@DeleteMapping("/matchWeek/{matchWeek_id}")
	public List<PremMatchWeek> deleteMatchWeek(@PathVariable String matchWeek_id){
			premMatchWeekService.deleteSingleMatchWeek(matchWeek_id);
			return allMatches();
	}
	
	@PutMapping("/matchWeek/{matchWeek_id}")
	public PremMatchWeek updateMatchWeek(@PathVariable String matchWeek_id,@RequestBody PremMatchWeek premMatchWeek){			
		return premMatchWeekService.updateMatchWeek(matchWeek_id, premMatchWeek);
	}
	
	@GetMapping("/matchWeekMatchId/{matchId}")
	public ResponseEntity<List<PremMatchWeek>> getResultsByMatchWeek(@PathVariable String matchId) {		
		List<PremMatchWeek>  resultData = premMatchWeekService.getAllByMatchWeekId(matchId);
		
		return ResponseEntity.ok(resultData);
	}

	@GetMapping("/matchWeekIds")
	public List<Integer> getMatchWeekIds(){
		return premMatchWeekService.getAllMatchWeekDays();
	}
	
}
