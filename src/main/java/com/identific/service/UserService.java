package com.identific.service;

import com.identific.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public User findUserById(Long id);

}