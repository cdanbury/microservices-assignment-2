package com.wsu.workorderproservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wsu.workorderproservice.model.Product;
import com.wsu.workorderproservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Object> getAll() {
        List<Product> products = productRepository.findAll(); 
        return Collections.singletonList(Product.builder().build());
    }
}
