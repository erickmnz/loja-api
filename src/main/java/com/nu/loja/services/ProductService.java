package com.nu.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nu.loja.entities.Product;
import com.nu.loja.entities.Order;
import com.nu.loja.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Integer id) {
		return repository.findById(id).get();
	}
}
