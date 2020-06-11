package com.usermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermgmt.domain.User;
import com.usermgmt.service.UserService;

/*
 * http://localhost:8080/api/users           --> UserController will be called.
 * http://localhost:8080/api/users/create    --> for creating users.
 * http://localhost:8080/api/users/allUsers  --> Get All Users .
 * http://localhost:8080/api/users/1         --> 1st user	.
 * http://localhost:8080/api/users/delete/1  --> 1st Deleted
 */
@RestController
@RequestMapping(value = "/api/users")

public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User u = userService.createUser(user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

	@GetMapping(value = "/allUsers")
	public Iterable<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(value = "/{userId}")
	public User getUserById(@PathVariable("userId") Integer userId) {
		return userService.getUser(userId);
	}

	@DeleteMapping(value = "/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
	}

}
