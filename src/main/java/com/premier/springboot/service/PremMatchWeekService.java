package com.premier.springboot.service;

import java.util.List;

import com.premier.springboot.model.PremMatchWeek;

public interface PremMatchWeekService {
	
	PremMatchWeek matchweekAdd(PremMatchWeek premMatchWeek);
	
	List<PremMatchWeek>  allMatches();
	
	List<PremMatchWeek> individualMatchResult(String teamName);
	
	void deleteSingleMatchWeek(String id);
	
	PremMatchWeek updateMatchWeek(String id,PremMatchWeek premMatchWeek);

	List<PremMatchWeek>  getAllByMatchWeekId(String matchId);
	
	List<Integer> getAllMatchWeekDays();
	
	

}
