package com.nu.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.loja.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	


}
