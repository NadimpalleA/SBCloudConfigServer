package com.vacc.center.entity;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class RequiredResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;
}
