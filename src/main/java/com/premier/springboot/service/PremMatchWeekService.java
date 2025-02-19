package com.premier.springboot.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.premier.springboot.model.PremMatchWeek;

@Repository
public interface PremMatchWeekService {
	
	PremMatchWeek matchweekAdd(PremMatchWeek premMatchWeek);
	
	List<PremMatchWeek>  allMatches();
	
	List<PremMatchWeek> individualMatchResult(String teamName);
	
	List<String> selectAwayTeamOptions(String teamName);
 	
	void deleteSingleMatchWeek(String id);
	
	PremMatchWeek updateMatchWeek(String id,PremMatchWeek premMatchWeek);

	List<PremMatchWeek>  getAllByMatchWeekId(String matchId);
	
	List<Integer> getAllMatchWeekDays();
	
	List<String> teamNamesSelectedonMatchWeek(String id);
	

}
