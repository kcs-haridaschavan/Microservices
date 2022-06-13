package com.kcsitglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.model.User;
import com.kcsitglobal.model.UserRequest;
import com.kcsitglobal.model.UserResponse;
import com.kcsitglobal.service.UserService;
import com.kcsitglobal.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService; // HAS-A

	@Autowired
	private JwtUtil jwtUtil;

	// 1.Save User in Database
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer id = userService.saveUser(user);
		String body = "User '" + id + "'saved";
		// return new ResponseEntity<String>(body,HttpStatus.OK);
		return ResponseEntity.ok(body);

	}

	// 2.Validate user and generate token Login
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request) {

		// TODO: Validate unm/pwd with database

		String token = jwtUtil.generateToken(request.getUsername());
		return ResponseEntity.ok(new UserResponse(token, "Sucess! Generated By KCSITGLOBAL"));
	}
}