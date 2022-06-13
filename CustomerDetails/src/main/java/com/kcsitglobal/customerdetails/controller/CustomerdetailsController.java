package com.kcsitglobal.customerdetails.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.customerdetails.model.Billing;
import com.kcsitglobal.customerdetails.model.Customer;
import com.kcsitglobal.customerdetails.service.CustomerdetailsService;

//import java.util.Arrays;
	//import java.util.List;
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

	@RestController
	@RequestMapping("/customerdeatils")
	public class CustomerdetailsController {
		
		@Autowired
		CustomerdetailsService customerdetailsService;

		@GetMapping("/get-Customers")
		public ResponseEntity<Customer[]> getCustomers() {
			
			return customerdetailsService.getCustomers();	
		}
		
		@GetMapping("/get-Customer-by-id")
		public ResponseEntity<Customer>getCustomersByid(@RequestParam Long cId){
			return customerdetailsService.getcustomerById(cId);
		}
		
		@GetMapping("get-customers-byname")
		public ResponseEntity<Customer[]> getCustomerByName(@RequestParam String name){
			
			return customerdetailsService.getCustomerByName(name);
			}
		
		@GetMapping("/get-customer-by-mobileno")
		public ResponseEntity<Customer[]> getCustomerBymobileno(@RequestParam Long mobileno) {
			
			return customerdetailsService.getCustomerBymobileno(mobileno);
			
		}
	@PostMapping("/save-record")
		public String saveRecord(@RequestBody Customer cust) {
			return customerdetailsService.saveRecord (cust);
		}
		
		@PutMapping("/update-record")
		public String updateRecord(@RequestBody Customer cust) {
			return customerdetailsService.updateRecord (cust);
		}
		
		@DeleteMapping("/delete-record")
		public String deleteRecord(@RequestParam Long cId) {
			return customerdetailsService.deleteRecord (cId);
			
			
		}
		//----------------------------------------------------------------------------------------------------------
		@GetMapping("/get-Bills")
		public ResponseEntity<Billing[]> getBills() {
			
			return customerdetailsService.getBills();	
		}
		@GetMapping("/getbillno")
		public ResponseEntity<Billing> getbillno(@RequestParam Long billno){
			return customerdetailsService.getbillno(billno);
		}
		
		@PostMapping("/save-record")
		public String saveRecord(@RequestBody Billing bill) {
			return customerdetailsService.saveRecord (bill);
		}
		
		@PutMapping("/update-record")
		public String updateRecord(@RequestBody Billing bill) {
			return customerdetailsService.updateRecord (bill);
		}
		
		@DeleteMapping("/delete-records")
		public String DeleteRecord(@RequestParam Long billno) {
			return customerdetailsService.deleteRecords (billno);
			
			
		}
		}



