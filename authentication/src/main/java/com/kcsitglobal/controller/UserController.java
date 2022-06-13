package com.kcsitglobal.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.entity.User;
import com.kcsitglobal.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRolesAndUser() {
		userService.initRolesAndUser();
	}

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);

	}

	@GetMapping({ "/forAdmin" })
	public String forAdmin() {
		return "This URL is only accessible to admin";
	}

	@GetMapping({ "/forUser" })
	public String forUser() {
		return "This URL is only accessible to the user";
	}

}
