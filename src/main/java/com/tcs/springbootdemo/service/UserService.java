package com.tcs.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.springbootdemo.entity.User;
import com.tcs.springbootdemo.exceptions.UserNotFoundException;
import com.tcs.springbootdemo.repository.IUserRepository;

@Service
public class UserService  implements IUserService{

	@Autowired
	IUserRepository userRerpository;
	
	@Override
	@Transactional(rollbackFor = Exception.class,
	noRollbackFor = IllegalStateException.class)
	public void save(User user){
		userRerpository.save(user);
		//used exceptions to see how transactional works when a exception is thrown 
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

	@Override
	public void deletUser(Integer id) {
		Optional<User> user =  userRerpository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("user does not exist");
		}
		userRerpository.deleteById(id);
	}

}
