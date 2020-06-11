package com.usermgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usermgmt.domain.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer>{

	public User findByFirstNameAndLastName(String firstName, String lastName);	
}
