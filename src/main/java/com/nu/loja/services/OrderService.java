package com.nu.loja.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nu.loja.entities.Order;
import com.nu.loja.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	public List<Order> findAll(){
		return repository.findAll();
	}
	public Order findById(Integer id) {
		return repository.findById(id).get();
	}
}
