package com.nu.loja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nu.loja.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

	  @Query(value= "select * from tb_user u where u.name =?1", nativeQuery=true)
	  List<User> findByFirstName(String name);
	  @Query(value= "select * from tb_user u where u.surname =?1", nativeQuery=true)
	  List<User> findBySurname(String surname);

}
