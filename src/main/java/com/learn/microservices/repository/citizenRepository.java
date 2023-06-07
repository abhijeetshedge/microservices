package com.learn.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.microservices.entity.Citizen;

public interface citizenRepository extends JpaRepository<Citizen, Integer> {

	List<Citizen> findByVaccinationCenterId(int id);

}
