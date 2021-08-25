package com.tcs.springbootdemo;

import java.util.Optional;

public interface IUserService {
	void save(User user);

	Iterable<User> getAll();

	Optional<User> getUser(Integer id);
}
