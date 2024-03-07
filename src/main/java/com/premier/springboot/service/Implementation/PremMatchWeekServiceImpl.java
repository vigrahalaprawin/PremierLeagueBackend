package com.premier.springboot.service.Implementation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premier.springboot.exception.ResourceNotFoundException;
import com.premier.springboot.model.PremMatchWeek;
import com.premier.springboot.repository.PremMatchWeekRepository;
import com.premier.springboot.service.PremMatchWeekService;


@Service
public class PremMatchWeekServiceImpl implements PremMatchWeekService {
	
	
	@Autowired
	PremMatchWeekRepository premMatchWeekRepo;	

	@Override
	public PremMatchWeek matchweekAdd(PremMatchWeek premMatchWeek) {
		return premMatchWeekRepo.save(premMatchWeek);
	}

	@Override
	public List<PremMatchWeek> allMatches() {
		List<PremMatchWeek> sortedList = premMatchWeekRepo.findAll();
		sortedList.sort(Comparator.comparing(PremMatchWeek::getMatchWeek));	
		return sortedList;	 
	}

	@Override
	public List<PremMatchWeek> individualMatchResult(String teamName) {	
		 List<PremMatchWeek> sortedList =premMatchWeekRepo.findAllSortedByteamName(teamName);
		 sortedList.sort(Comparator.comparing(PremMatchWeek::getMatchWeek));	
		 return sortedList;
		}

	
	public void deleteSingleMatchWeek(String matchId) {
		premMatchWeekRepo.deleteById(Long.parseLong(matchId));
	}
	
	public PremMatchWeek updateMatchWeek(String matchId,PremMatchWeek premMatchWeek)
	{
		
	PremMatchWeek pmw = premMatchWeekRepo.findById(Long.parseLong(matchId)).orElseThrow(
					()-> new ResourceNotFoundException("Match Week does not exit team not exist"));
	      pmw.setAwayScore(premMatchWeek.getAwayScore());
	      pmw.setAwayTeam(premMatchWeek.getAwayTeam());
	      pmw.setHomeScore(premMatchWeek.getHomeScore());
	      pmw.setHomeTeam(premMatchWeek.getHomeTeam());
	      pmw.setMatchWeek(premMatchWeek.getMatchWeek());
	      
	      PremMatchWeek updatedTeam = premMatchWeekRepo.save(pmw); 
	      return updatedTeam;
		}
	
	
	public List<PremMatchWeek> getAllByMatchWeekId(String matchId){	
		return premMatchWeekRepo.findAllById(Long.parseLong(matchId));
	}
	
	public List<Integer> getAllMatchWeekDays() {
		List<Integer> matchIds = premMatchWeekRepo.getAllMatchWeekIds();
		Collections.sort(matchIds);
		return matchIds ;
	}

	public List<String> teamNamesSelectedonMatchWeek(String id){
		List<Object[]> resultObj =  premMatchWeekRepo.getAllmatchWeekteamNames(Long.parseLong(id));
		List<String> teamNames = new ArrayList<>();
		for (Object[] obj : resultObj) {
		    if (obj != null) {
		        teamNames.add((String) obj[0]);
		        teamNames.add((String) obj[1]);
		    }
		}
		return teamNames.stream().distinct().collect(Collectors.toList());
	}
	
	

}
