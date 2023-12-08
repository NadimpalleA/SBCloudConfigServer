package com.programming.techie.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programming.techie.entity.Product;

public interface ProductRepo extends MongoRepository<Product, Integer> {

}
