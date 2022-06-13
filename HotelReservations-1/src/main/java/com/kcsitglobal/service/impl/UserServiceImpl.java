package com.kcsitglobal.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kcsitglobal.model.User;
import com.kcsitglobal.repository.RoleRepository;
import com.kcsitglobal.repository.UserRepository;
import com.kcsitglobal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	/*@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public User getById(int id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent())
			user = optional.get();
		else
			throw new RuntimeException("User not found for id:" + id);
		return user;

	}

	@Override
	public void deleteViaId(int id) {
		userRepository.deleteById(id);

	}

}
*/
	
	    @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private RoleRepository roleRepository;
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Override
	    public void save(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(new HashSet<>(roleRepository.findAll()));
	        userRepository.save(user);
	    }

	    @Override
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
	}