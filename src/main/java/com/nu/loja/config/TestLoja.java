package com.nu.loja.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nu.loja.entities.User;
import com.nu.loja.repositories.UserRepository;
@Configuration
@Profile("test")
public class TestLoja implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Bob","Brown", "bob@bob.com", "999999999","233");
		User u2 = new User(null, "Mark", "Brown", "mark@bob.com", "999991999","233");

		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
