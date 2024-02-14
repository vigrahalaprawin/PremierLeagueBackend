package com.premier.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class PremierloginController {

	@GetMapping("/")
	public String homePage() {
		return "we are in login controller ";
	}
	
	

}
