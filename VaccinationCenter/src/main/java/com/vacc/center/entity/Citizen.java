package com.vacc.center.entity;

import jakarta.persistence.Column;

public class Citizen {
	
    private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="vaccCenterId")
	private int vaccCenterId;
}
