package com.tcs.springbootdemo;

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

}
