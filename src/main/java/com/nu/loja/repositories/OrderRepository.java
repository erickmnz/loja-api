package com.nu.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nu.loja.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
