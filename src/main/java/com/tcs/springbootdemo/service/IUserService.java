package com.tcs.springbootdemo.service;

import java.util.Optional;

import com.tcs.springbootdemo.User;

public interface IUserService {
	void save(User user);

	Iterable<User> getAll();

	Optional<User> getUser(Integer id);

	void deletUser(Integer id);
}
