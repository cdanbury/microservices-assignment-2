package com.wsu.workorderproservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsu.workorderproservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    
}
