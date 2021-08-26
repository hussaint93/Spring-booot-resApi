package com.tcs.springbootdemo.service;

import java.util.Optional;

import com.tcs.springbootdemo.entity.User;

public interface IUserService {
	void save(User user) throws Exception;

	Iterable<User> getAll();

	Optional<User> getUser(Integer id);

	void deletUser(Integer id);
}
