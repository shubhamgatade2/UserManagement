package com.app.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.main.model.Users;

@Repository
public interface ProfileRepository extends CrudRepository<Users, Integer> {
	
	Users findAllByPhonenumberAndPassword(String phonenumber,String password);

	Users findById(int userid);
}
