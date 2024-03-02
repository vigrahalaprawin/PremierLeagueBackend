package com.premier.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="matchWeek")
public class PremMatchWeek {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long matchId;
	
	
	
	@Column(nullable = false)
	private String homeTeam;
	
	@Column(nullable = false)
	private String awayTeam;
	
	
	private int homeScore;
	
	private int AwayScore;
	
	@Column(nullable = false)
	private int  matchWeek;
	
	
	public PremMatchWeek() {
		
	}
	
	public Long getMatchId() {
		return matchId;
	}


	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}
	
	
	public PremMatchWeek(int matchWeek, String homeTeam, String awayTeam, int homeScore, int awayScore) {
		super();
		this.matchWeek = matchWeek;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.AwayScore = awayScore;
	}
	
	public int getMatchWeek() {
		return matchWeek;
	}
	public void setMatchWeek(int matchWeek) {
		this.matchWeek = matchWeek;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getAwayScore() {
		return AwayScore;
	}
	public void setAwayScore(int awayScore) {
		AwayScore = awayScore;
	}
	
	
	

}
