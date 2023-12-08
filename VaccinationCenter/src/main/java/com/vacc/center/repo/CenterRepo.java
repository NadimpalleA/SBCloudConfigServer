package com.vacc.center.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacc.center.entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
