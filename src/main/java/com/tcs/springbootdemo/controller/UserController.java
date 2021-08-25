package com.tcs.springbootdemo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springbootdemo.User;
import com.tcs.springbootdemo.exceptions.UserNotFoundException;
import com.tcs.springbootdemo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	IUserService userservice;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	 private Iterable<User> getuser(){
			return userservice.getAll();
		}
	@GetMapping("/{id}")
	 private Optional<User> getOneUser(@PathVariable("id") Integer id){
			return userservice.getUser(id);
		}
	@PostMapping
	private void saveUser(@RequestBody User user) {
		userservice.save(user);
		logger.debug(user.getFirstName());
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userservice.deletUser(id);
	}
	
	@PutMapping
	private void updateUser(@RequestBody User user) {
		userservice.save(user);
		System.out.println(user.getFirstName());
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<User> exception(RuntimeException runTimeException) {
	      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	   }
}