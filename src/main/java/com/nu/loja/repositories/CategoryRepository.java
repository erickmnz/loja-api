package com.nu.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.loja.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	


}
