package com.newsportal.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.newsportal.domain.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	User findByUsername(String username);

}