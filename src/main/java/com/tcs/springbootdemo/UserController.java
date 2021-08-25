package com.tcs.springbootdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/user/{id}")
	 private Optional<User> getOneUser(@PathVariable("id") Integer id){
			return userservice.getUser(id);
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
	
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<User> exception(UserNotFoundException userNotFoundException) {
	      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	   }
}
