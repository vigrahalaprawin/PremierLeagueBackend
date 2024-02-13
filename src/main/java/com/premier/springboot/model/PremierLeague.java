package com.premier.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="premier")
public class PremierLeague {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	
	private String teamName;
	private String teamCoach;
	
	private String teamStadium;
	
	public PremierLeague() {
		super();
	}
	
	
	public PremierLeague(String teamName, String teamCoach, String teamStadium) {
		super();
		this.teamName = teamName;
		this.teamCoach = teamCoach;
		this.teamStadium = teamStadium;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCoach() {
		return teamCoach;
	}
	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}
	public String getTeamStadium() {
		return teamStadium;
	}
	public void setTeamStadium(String teamStadium) {
		this.teamStadium = teamStadium;
	}
	
	

}
