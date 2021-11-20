package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public interface ProductService {

	List<Product> getAllProduct();

}
