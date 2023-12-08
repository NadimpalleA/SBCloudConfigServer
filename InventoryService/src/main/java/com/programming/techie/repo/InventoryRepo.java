package com.programming.techie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming.techie.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory,Long>{

	Optional<Inventory> findBySkuCode(String skuCode);

}