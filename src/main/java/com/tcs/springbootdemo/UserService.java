package com.tcs.springbootdemo;

import org.springframework.stereotype.Service;

@Service
public class UserService  implements IUserService{

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("saved");
	}

}
