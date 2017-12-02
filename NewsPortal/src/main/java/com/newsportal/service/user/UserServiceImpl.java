package com.newsportal.service.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.newsportal.domain.user.Role;
import com.newsportal.domain.user.User;
import com.newsportal.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		if(user == null) {
			throw new IllegalArgumentException("Empty body");
		}
		log.info("About to register new user with username:" + user.getUsername());
		
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if(existingUser != null) {
			throw new IllegalArgumentException("User already exists in DB");
		}
		
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRoles(Arrays.asList(new Role("USER")));
		return userRepository.save(newUser);
	}

	@Override
	public String removeUser(String id) {
		
		User user = userRepository.findOne(id);
		
		if(user == null) {
			return "User not found";
		}
		
		userRepository.delete(user);
		
		return "user " + id + " removed";
	}

	@Override
	public User addNewRole(String id, String role) {
		if(role.equals("")) {
			throw new IllegalArgumentException("Please enter valid role name");
		}
		
		User user = userRepository.findOne(id);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not found");
		}
		
		List<Role> currentRoles = user.getRoles();
		
		for(Role currentRole : currentRoles) {
			if (currentRole.getName().equalsIgnoreCase(role)) {
				throw new DuplicateKeyException("The role is already assigned to this user");
			}
		}
		
		currentRoles.add(new Role(role.toUpperCase()));
		user.setRoles(currentRoles);
		return userRepository.save(user);
	}
	
	@Override
	public User removeRole(String id, String role) {
		if(role.equals("")) {
			throw new IllegalArgumentException("Please enter valid role name");
		}
		
		User user = userRepository.findOne(id);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not found");
		}
		
		List<Role> currentRoles = user.getRoles();
		
		List<Role> rolesToRemove = new ArrayList<>();
		
		for (Role currentRole : currentRoles) {
		    if (role.equalsIgnoreCase(currentRole.getName())) {
		        rolesToRemove.add(currentRole);
		    }
		}
		
		currentRoles.removeAll(rolesToRemove);

		user.setRoles(currentRoles);
		return userRepository.save(user);
	}

}