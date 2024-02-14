 package com.premier.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.premier.springboot.model.PremMatchWeek;

public interface PremMatchWeekRepository extends JpaRepository<PremMatchWeek, Long> {
	
	 @Query(value = "select * from match_week where away_team=:teamName OR  home_team=:teamName",nativeQuery=true)
	 List<PremMatchWeek> findAllSortedByteamName(String teamName);
}
