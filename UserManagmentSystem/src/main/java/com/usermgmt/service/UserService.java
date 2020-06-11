package com.usermgmt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermgmt.dao.UserDAO;
import com.usermgmt.domain.User;
import com.usermgmt.exception.NoUserExistsException;
import com.usermgmt.exception.UserAlreadyExistsException;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;

	public User createUser(User user) {		
		User u = getUserByFirstNameAndLastName(user.getFirstName(),user.getLastName());
		if(u==null) {
			return userDao.save(user);
		}else {
			throw new UserAlreadyExistsException("....");
		}
	}

	public Iterable<User> getAllUsers() {
		return userDao.findAll();
	}

	public void deleteUser(Integer userId) {
		Optional<User> u = userDao.findById(userId);
		if(userId==null || !u.isPresent()) {
			throw new NoUserExistsException("....");
		}else {			
			userDao.deleteById(userId);
		}
		
	}

	public User getUser(Integer userId) {		
		return userDao.findById(userId).orElse(new User());
	}

	public User getUserByFirstNameAndLastName(String firstName , String lastName) {
		return userDao.findByFirstNameAndLastName(firstName, lastName);
	}

}
