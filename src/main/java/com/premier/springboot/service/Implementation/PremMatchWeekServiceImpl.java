package com.premier.springboot.service.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.premier.springboot.model.PremMatchWeek;
import com.premier.springboot.repository.PremMatchWeekRepository;
import com.premier.springboot.service.PremMatchWeekService;


@Service
public class PremMatchWeekServiceImpl implements PremMatchWeekService {
	
	
	@Autowired
	PremMatchWeekRepository premMatchWeekRepo;
	

	@Override
	public PremMatchWeek matchweekUpdate(PremMatchWeek premMatchWeek) {
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

}
