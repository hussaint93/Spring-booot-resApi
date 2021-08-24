package com.tcs.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	IUserService userservice;
	
	@GetMapping("/getuser")
	 private String getuser(){
		System.out.println("hello");
			return "hello world";
		}
	@PostMapping("/user")
	private void saveUser(@RequestBody User user) {
		userservice.save(user);
		System.out.println(user.getFirstName());
	}
}
