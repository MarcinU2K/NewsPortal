package com.newsportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<User> register(@RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.register(user));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/remove/{id}/" , method = RequestMethod.DELETE)
	public ResponseEntity<?> removeUser(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(userService.removeUser(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/id/{id}/role/{role}/", method = RequestMethod.PUT)
	public ResponseEntity<User> addNewRole(@PathVariable("id")String id, @PathVariable("role") String role) {
		try {
			return ResponseEntity.ok(userService.addNewRole(id, role));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/id/{id}/role/{role}/", method = RequestMethod.DELETE)
	public ResponseEntity<User> removeRole(@PathVariable("id")String id, @PathVariable("role") String role) {
		try {
			return ResponseEntity.ok(userService.removeRole(id, role));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}