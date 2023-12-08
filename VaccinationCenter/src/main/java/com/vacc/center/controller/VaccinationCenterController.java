package com.vacc.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vacc.center.entity.Citizen;
import com.vacc.center.entity.RequiredResponse;
import com.vacc.center.entity.VaccinationCenter;
import com.vacc.center.repo.CenterRepo;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

	
	@Autowired
	private CenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/create")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter newVaccCenter){
		
		VaccinationCenter center=centerRepo.save(newVaccCenter);
		return new ResponseEntity<>(center,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenter(@PathVariable Integer id){
		RequiredResponse requiredResponse=new RequiredResponse();
		
		// 1st get Vaccination Center details
		
	    VaccinationCenter center=centerRepo.findById(id).get();
		requiredResponse.setCenter(center);
		
		//then get all citizen registered to Vaccination Center
         List<Citizen> listOfCitizen= restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
         
         requiredResponse.setCitizens(listOfCitizen);
	    return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	
	}
	
}
