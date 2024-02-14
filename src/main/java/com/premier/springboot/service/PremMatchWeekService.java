package com.premier.springboot.service;

import java.util.List;

import com.premier.springboot.model.PremMatchWeek;

public interface PremMatchWeekService {
	
	public PremMatchWeek matchweekUpdate(PremMatchWeek premMatchWeek);
	
	List<PremMatchWeek>  allMatches();
	
	List<PremMatchWeek> individualMatchResult(String teamName);
	
	//List<String> getTeamNames(String teamName);
	
	
	

}
