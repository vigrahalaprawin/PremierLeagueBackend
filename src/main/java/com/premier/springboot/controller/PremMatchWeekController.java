package com.premier.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		return premMatchWeekService.matchweekUpdate(premMatchWeek);
	}
	
	@GetMapping("/allMatchWeek")
	public List<PremMatchWeek> allMatches(){
		return premMatchWeekService.allMatches();
	}
	
	@GetMapping("/teamResults/{teamName}")
	public List<PremMatchWeek> getIndividualTeamResults(@PathVariable String teamName){
		return premMatchWeekService.individualMatchResult(teamName);
	}

	
//	@GetMapping("/teamSorting/{teamName}")
//	public List<String> getSortedNames(@PathVariable String teamName){
//		return premMatchWeekService.
//	}
//	
	
}
