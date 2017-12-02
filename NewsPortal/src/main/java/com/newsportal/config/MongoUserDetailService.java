package com.newsportal.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.newsportal.domain.user.Role;
import com.newsportal.domain.user.User;
import com.newsportal.repository.user.UserRepository;

@Service
public class MongoUserDetailService implements UserDetailsService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("in loadUserByUsername with user: " + username);
			
		User user = userRepository.findByUsername(username);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				enabled, accountNonExpired, 
				credentialsNonExpired, accountNonLocked, 
				getAuthorities(user.getRoles()));
	}
	
	private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		
		for(Role role: roles) {
			authList.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			log.info("Loaded authority " + role.getName());
		}
		return authList;
	}

}