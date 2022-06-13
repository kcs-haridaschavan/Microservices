package com.kcsitglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.model.Customer;
import com.kcsitglobal.service.CustomerService;

@RestController
@RequestMapping("/resttemplate-customer")

public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/get-customers")
	public ResponseEntity<Customer[]> getCustomers() {

		return customerService.getCustomers();
	}

	@GetMapping("/get-customer-by-id")
	public ResponseEntity<Customer> getCustomerByid(@RequestParam Long custId) {
		return customerService.getCustomerByid(custId);
	}

	@GetMapping("get-customer-by-mobileno")
	public ResponseEntity<Customer[]> getcustomerByMobileno(@RequestParam Long mobileno) {

		return customerService.getCustomerByMobileno(mobileno);
	}

	@GetMapping("get-customer-by-name")
	public ResponseEntity<Customer[]> getcustomerByname(@RequestParam String name) {

		return customerService.getCustomerByname(name);
	}

	@PostMapping("/save-record")
	public String saveRecord(@RequestBody Customer customer) {
		return customerService.saveRecord(customer);
	}

	@PutMapping("/update-record")
	public String updateRecord(@RequestBody Customer customer) {
		return customerService.updateRecord(customer);
	}

	@DeleteMapping("/delete-record")
	public String deleteRecord(@RequestParam Long custId) {
		return customerService.deleteRecord(custId);

	}

}
