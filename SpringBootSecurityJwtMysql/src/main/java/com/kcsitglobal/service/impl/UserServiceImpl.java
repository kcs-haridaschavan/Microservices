package com.kcsitglobal.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kcsitglobal.model.User;
import com.kcsitglobal.repository.UserRepository;
import com.kcsitglobal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;// HAS-A
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	// save method
	@Override
	public Integer saveUser(User user) {

		// TODO:Encode Password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return userRepository.save(user).getId();
	}
	// get user by username

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

//----------------------------------------------------------------

	public UserDetails loadUserByname(String username) throws UsernameNotFoundException {
		Optional<User> opt =findByUsername(username);
		if(opt.isEmpty()) 
			throw new UsernameNotFoundException("user not exist");
			//read user from DB
		User user=opt.get();
		
		return new org.springframework.security.core.userdetails.User(username,user.getPassword()
				,user.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(username))
				.collect(Collectors.toList())
				);
	}
}
