package com.learn.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservices.entity.Citizen;
import com.learn.microservices.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {


	@Autowired
	private CitizenService service;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getAllCitizensByVaciinationCenterId
	(@PathVariable Integer id){
		
		List<Citizen> listOfCitizens = service.findCitizensByVaccinationCenterId(id);
		return new ResponseEntity<>(listOfCitizens, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizez(@RequestBody Citizen newCitizen){
		Citizen citizen = service.saveCitizenData(newCitizen);
		return new ResponseEntity<>(citizen, HttpStatus.ACCEPTED);
		
	}
	
}
