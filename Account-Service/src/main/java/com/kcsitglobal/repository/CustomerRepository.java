package com.kcsitglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
