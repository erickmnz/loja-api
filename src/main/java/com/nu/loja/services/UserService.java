package com.nu.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nu.loja.entities.User;
import com.nu.loja.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}

	public User findById(Integer id) {
		Optional<User> opt = repository.findById(id);
		return opt.get();
	}

	public List<User> findByFirstName(String name){
		return repository.findByFirstName(name);
	}
	
	public List<User> findBySurname(String surname){
		return repository.findBySurname(surname);
	}
	

}
