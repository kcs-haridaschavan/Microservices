package com.kcsitglobal.service;

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

import com.kcsitglobal.model.Customer;

@Service
public class CustomerService {
	@Autowired
	RestTemplate template;

	public ResponseEntity<Customer[]> getCustomers() {

		final String url = "http://localhost:2020/customer/get-customers";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);

		List<Customer> customer = Arrays.asList(response.getBody());

		System.out.println(customer.toString());

		return response;
	}

	public ResponseEntity<Customer> getCustomerByid(Long custId) {
		final String url = "http://localhost:2020/customer/get-customertId?custId=" + custId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Customer> response = template.exchange(url, HttpMethod.GET, entity, Customer.class);
		Customer customer = response.getBody();
		System.out.println(customer.toString());

		return response;
	}

	public ResponseEntity<Customer[]> getCustomerByMobileno(Long mobileno) {

		final String url = "http://localhost:2020/customer/get-customerBymobileno?mobileno=" + mobileno;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);

		List<Customer> customer = Arrays.asList(response.getBody());
		System.out.println(customer.toString());

		return response;
	}

	/*
	 * @HystrixCommand(fallbackMethod = "showResponse", commandProperties = {
	 * 
	 * @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
	 * value = "10000") }) // @HystrixCommand(fallbackMethod = "showResponse")
	 */
	public String saveRecord(Customer customer) {

		final String url = "http://localhost:2020/customer/add-customer";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);

		return template.exchange(url, HttpMethod.POST, entity, String.class).getBody();
	}

	/*
	 * public String showResponse(Customer p) { return
	 * "Request fails. It takes long time to response"; }
	 */
	public String updateRecord(Customer customer) {

		final String url = "http://localhost:2020/customer/update-customer";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);
		return template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
	}

	public String deleteRecord(Long custId) {

		final String url = "http://localhost:2020/customer/delete-customer?custId=" + custId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(headers);
		return template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
	}

	public ResponseEntity<Customer[]> getCustomerByname(String name) {
		final String url = "http://localhost:2020/customer/get-customerByName?name=" + name;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);

		List<Customer> customer = Arrays.asList(response.getBody());
		System.out.println(customer.toString());

		return response;
	}

}
