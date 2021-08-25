package com.tcs.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	IUserService userservice;
	
	@GetMapping("/user")
	 private Iterable<User> getuser(){
			return userservice.getAll();
		}
	@PostMapping("/user")
	private void saveUser(@RequestBody User user) {
		userservice.save(user);
		System.out.println(user.getFirstName());
	}
	@PutMapping("/user")
	private void updateUser(@RequestBody User user) {
		userservice.save(user);
		System.out.println(user.getFirstName());
	}
}
