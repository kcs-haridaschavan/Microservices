package com.kcsitglobal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcsitglobal.entity.Customer;
import com.kcsitglobal.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		double fee = customer.getFee();
		double tax = (fee * 10) / 100;
		double totalvalue = fee + tax;
		customer.setTotalValue(totalvalue);
		customer.setTax(tax);
		Customer customers = customerRepository.save(customer);
		return customers;
	}

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElse(null);

	}

}
