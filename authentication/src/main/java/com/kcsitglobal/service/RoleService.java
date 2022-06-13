package com.kcsitglobal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kcsitglobal.entity.Role;
import com.kcsitglobal.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}
}
