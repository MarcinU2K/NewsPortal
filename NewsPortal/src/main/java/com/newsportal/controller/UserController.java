package com.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newsportal.domain.user.User;
import com.newsportal.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("permitAll()")
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public User register(@RequestBody User user) {
		return userService.register(user);	
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/remove/{id}/" , method = RequestMethod.DELETE)
	public String removeUser(@PathVariable("id") String id) {
		return userService.removeUser(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/id/{id}/role/{role}/", method = RequestMethod.PUT)
	public User addNewRole(@PathVariable("id")String id, @PathVariable("role") String role) {
		return userService.addNewRole(id, role);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/id/{id}/role/{role}/", method = RequestMethod.DELETE)
	public User removeRole(@PathVariable("id")String id, @PathVariable("role") String role) {
		return userService.removeRole(id, role);
	}
}