package com.newsportal.service.user;

import com.newsportal.domain.user.User;

public interface UserService {
	
	User register(User user);

	String removeUser(String id);

	User addNewRole(String id, String role);
	
	User removeRole(String id, String role);
}