package com.premier.springboot.service.Implementation;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.premier.springboot.exception.ResourceNotFoundException;
import com.premier.springboot.model.PremierLeague;
import com.premier.springboot.repository.PremMatchWeekRepository;
import com.premier.springboot.repository.PremierRepository;
import com.premier.springboot.service.PremierServiceRepo;


@Service
public class PremierTeamServiceImpl implements PremierServiceRepo  {
	
	@Autowired
	PremierRepository premierRepository;
	
	@Autowired
	PremMatchWeekRepository premMatchWeekRepo;
	

	@Override
	public List<String> getAllPremierTeamNames(){		
		  return premierRepository.allPremierTeams().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());	
	}
	
	
	@Override
	public ResponseEntity<PremierLeague> updatePremTeam(String id,PremierLeague premLeague) {
		
		PremierLeague premierLeague = premierRepository.findById(Long.parseLong(id)).orElseThrow(
				()-> new ResourceNotFoundException("Prem team not exist"));
		premierLeague.setTeamName(premLeague.getTeamName());
		premierLeague.setTeamCoach(premLeague.getTeamCoach());
		premierLeague.setTeamStadium(premLeague.getTeamStadium());	
		PremierLeague updatedTeam = premierRepository.save(premierLeague);
		return ResponseEntity.ok(updatedTeam);
		
	}



	@Override
	public List<PremierLeague> showPremTeamWithIds() {		
		List<Object[]> testinglist = premierRepository.showAllPremierTeamsWithId();
		List<PremierLeague> premierLeagues = new ArrayList<>();
		for (Object[] result : testinglist) {	
			Long id = Long.parseLong(result[0].toString());
		    String teamName = (String) result[1];
		    PremierLeague premierLeague = new PremierLeague(id, teamName);
		    premierLeagues.add(premierLeague);
		}
		return premierLeagues;
	}


	@Override
	public List<PremierLeague> getAllTeamsInfo() {
		List<PremierLeague> premTeams = premierRepository.findAll();
		premTeams.sort(Comparator.comparing(PremierLeague:: getTeamName));
		return premTeams;
	}
	
	
	public void deleteByIdFromTable(String id) {
	
		PremierLeague pm  = premierRepository.getReferenceById(Long.parseLong(id));
		premMatchWeekRepo.findAllSortedByteamName(pm.getTeamName()).stream().
		forEach(p->premMatchWeekRepo.deleteById(p.getMatchId()));
		premierRepository.deleteById(Long.parseLong(id));
		
		
		
	}
 

}
