package com.programming.techie.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(value="Product")
@Data
@Builder
public class Product {

	@Id
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
