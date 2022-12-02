package com.nu.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.loja.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	


}
