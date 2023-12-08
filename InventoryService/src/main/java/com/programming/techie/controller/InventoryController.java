package com.programming.techie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.entity.Inventory;
import com.programming.techie.repo.InventoryRepo;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryRepo inventoryRepository;
	
	@GetMapping("/skuCode")
	Boolean isInStock(@PathVariable String skuCode) {
		Inventory inventory=inventoryRepository.findBySkuCode(skuCode).orElseThrow(()->new RuntimeException("cannot find sku code :"+skuCode));
		return inventory.getStock()>0;
		
	}
	
	
}
