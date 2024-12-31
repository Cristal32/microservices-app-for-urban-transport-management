package com.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.auth.dto.CustomUserDetails;
import com.auth.model.User;
import com.auth.repository.UserDao;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user =  userDao.findByEmail(email);
		return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with email" + email));
	}
	
}
