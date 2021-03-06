package com.kcsitglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.client.AccountServiceClient;
import com.kcsitglobal.client.ProductServiceClient;
import com.kcsitglobal.entity.CustomerReport;
import com.kcsitglobal.entity.ProductReport;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

	@Autowired
	private AccountServiceClient accountServiceClient;
	@Autowired
	private ProductServiceClient productServiceClient;

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerReport>> getAllCustomerReport() {
		List<CustomerReport> customerReportList = accountServiceClient.getAllCustomerReport();

		return new ResponseEntity<List<CustomerReport>>(customerReportList, HttpStatus.OK);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerReport> getCustomerById(@PathVariable("id") int id) {
		CustomerReport customerReport = accountServiceClient.getCustomerReportById(id);
		return new ResponseEntity<CustomerReport>(customerReport, HttpStatus.OK);
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductReport>> getAllProductReport() {
		List<ProductReport> productReportList = productServiceClient.getAllProductReport();
		return new ResponseEntity<List<ProductReport>>(productReportList, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductReport> getProductById(@PathVariable("id") int id) {
		ProductReport productReport = productServiceClient.getProductReportById(id);
		return new ResponseEntity<ProductReport>(productReport, HttpStatus.OK);
	}

}
