package com.premier.springboot.service.Implementation;


import java.util.List;

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
		premMatchWeekRepo.save(premMatchWeek);
		return premMatchWeekRepo.save(premMatchWeek);
	}

	@Override
	public List<PremMatchWeek> allMatches() {
		return premMatchWeekRepo.findAll();
	}

	@Override
	public List<PremMatchWeek> individualMatchResult(String teamName) {
		return premMatchWeekRepo.findAllSortedByteamName(teamName);
		}

	
	
	public List<PremMatchWeek> gettingteamname(String teanName){
	
		return premMatchWeekRepo.findAllSortedByteamName(teanName);
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
	

}
