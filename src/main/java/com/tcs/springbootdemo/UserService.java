package com.tcs.springbootdemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  implements IUserService{

	@Autowired
	IUserRepository userRerpository;
	
	@Override
	public void save(User user) {
		userRerpository.save(user);
		System.out.println("saved");
	}

	@Override
	public Iterable<User> getAll() {
		
		return userRerpository.findAll();
	}

	@Override
	public Optional<User> getUser(Integer id) {
		Optional<User> user =  userRerpository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("user does not exist");
		}
		return user;
	}

}
