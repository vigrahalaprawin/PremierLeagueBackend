 package com.premier.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.premier.springboot.model.PremMatchWeek;

public interface PremMatchWeekRepository extends JpaRepository<PremMatchWeek, Long> {
	
	 @Query(value = "select * from match_week where away_team=:teamName OR  home_team=:teamName",nativeQuery=true)
	 List<PremMatchWeek> findAllSortedByteamName(String teamName);

	@Query(value = "select * from match_week where match_week=:matchId",nativeQuery=true)
	List<PremMatchWeek> findAllById(Long matchId);
	
	@Query(value = "select distinct match_week from match_week",nativeQuery = true)
	List<Integer> getAllMatchWeekIds();
	
	@Query(value = "select away_team,home_team from match_week where match_week=:matchId",nativeQuery = true)
	List<Object[]> getAllmatchWeekteamNames(Long matchId);

}
