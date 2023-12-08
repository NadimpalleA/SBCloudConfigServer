package com.citizen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citizen.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
public List<Citizen>  findByVaccCenterId(int id);
}
