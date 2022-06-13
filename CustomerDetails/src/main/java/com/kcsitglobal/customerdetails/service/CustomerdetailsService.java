package com.kcsitglobal.customerdetails.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kcsitglobal.customerdetails.model.Billing;
import com.kcsitglobal.customerdetails.model.Customer;

@Service
public class CustomerdetailsService {
	@Autowired
	RestTemplate template;

	public ResponseEntity<Customer[]> getCustomers() {

		final String url = "http://localhost:2020/customer/get-customers";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);

		List<Customer> products = Arrays.asList(response.getBody());

		System.out.println(products.toString());

		return response;
	}

	public ResponseEntity<Customer> getcustomerById(Long cId) {
		final String url = "http://localhost:2020/customer/get-customertId?cId=" + cId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Customer> response = template.exchange(url, HttpMethod.GET, entity, Customer.class);
		Customer customer = response.getBody();
		System.out.println(customer.toString());

		return response;
	}

	public ResponseEntity<Customer[]> getCustomerByName(String name) {

		final String url = "http://localhost:2020/customer/get-customerByName?name=" + name;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);

		List<Customer> customer = Arrays.asList(response.getBody());
		System.out.println(customer.toString());

		return response;
	}

	public ResponseEntity<Customer[]> getCustomerBymobileno(Long mobileno) {

		final String url = "http://localhost:2020/customer/get-customerBymobileno?mobileno" + mobileno;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);

		List<Customer> products = Arrays.asList(response.getBody());

		System.out.println(products.toString());

		return response;
	}

	// @HystrixCommand(fallbackMethod = "showResponse", commandProperties = {
	// @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",
	// value = "10000") })
	// @HystrixCommand(fallbackMethod = "showResponse")
	public String saveRecord(Customer cust) {

		final String url = "http://localhost:2020/customer/add-customer";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);

		return template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	/*
	 * public String showResponse(Products p) { return
	 * "Request fails. It takes long time to response"; }
	 */
	public String updateRecord(Customer cust) {

		final String url = "http://localhost:2020/customer/update-customer";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);
		return template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
	}

	public String deleteRecord(Long cId) {

		final String url = "http://localhost:2020/customer/delete-customer?cId" + cId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
		return template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
	}

	public ResponseEntity<Billing[]> getBills() {
		final String url = "http://localhost:8089/billing/get-bills";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Billing[]> response = template.exchange(url, HttpMethod.GET, entity, Billing[].class);

		List<Billing> bill = Arrays.asList(response.getBody());

		System.out.println(bill.toString());

		return response;
	}

	public ResponseEntity<Billing> getbillno(Long billno) {
		final String url = "http://localhost:8089/billing/get-billno?billno=" + billno;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Billing> response = template.exchange(url, HttpMethod.GET, entity, Billing.class);
		Billing bill = response.getBody();
		System.out.println(bill.toString());

		return response;
	}

	public String saveRecord(Billing bill) {
		final String url = "http://localhost:8089/billing/add-bills";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Billing> entity = new HttpEntity<Billing>(bill, headers);

		return template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	public String updateRecord(Billing bill) {
		final String url = "http://localhost:8089/billing/update-bill";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Billing> entity = new HttpEntity<Billing>(bill, headers);
		return template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
		
	}

	public String deleteRecords(Long billno) {
		

		final String url = "http://localhost:8089/billing/delete-bill?billno=" + billno;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
		return template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
	}

}
