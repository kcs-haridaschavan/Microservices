package com.kcsitglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
