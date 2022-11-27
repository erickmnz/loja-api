package com.nu.loja.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nu.loja.entities.User;
import com.nu.loja.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable  Integer id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value="/u{name}")
	public ResponseEntity<List<User>> findByFirstName(@RequestParam(value="name") String name){
		List<User> list = service.findByFirstName(name);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/n{surname}")
	public ResponseEntity<List<User>> findBySurname(@RequestParam(value="surname") String surname){
		List<User> list = service.findBySurname(surname);
		return ResponseEntity.ok().body(list);
	}

	
	

	
	
	
	
}
