package com.learn.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.microservices.entity.Citizen;
import com.learn.microservices.repository.citizenRepository;

@Service
public class CitizenService{


	@Autowired
	private citizenRepository repo;
	
	public List<Citizen> findCitizensByVaccinationCenterId(int id){
		
		return repo.findByVaccinationCenterId(id);
	}
	
	public Citizen saveCitizenData(Citizen newCitizen) {
		return repo.save(newCitizen);
	}
}
