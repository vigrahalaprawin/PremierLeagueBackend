package com.premier.springboot.model;



import javax.persistence.Column;
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
	
	
	@Column(name = "team_name",nullable = false)
	private String teamName;
	
	
	@Column(name = "team_coach",nullable = false) 
	private String teamCoach;
	
	@Column(name = "team_stadium",nullable = false) 
	private String teamStadium;

	
	public PremierLeague() {
		
		super();
	}
	
	
	public PremierLeague(Long id,String teamName) {
	
		this.id = id;
		this.teamName = teamName;
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
