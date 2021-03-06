package com.kcsitglobal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kcsitglobal.entity.CustomerReport;

import java.util.List;

@FeignClient(name = "Account-Service")
public interface AccountServiceClient {

	@GetMapping("api/customers")
	public List<CustomerReport> getAllCustomerReport();

	@GetMapping("api/customers/{id}")
	public CustomerReport getCustomerReportById(@PathVariable("id")int id);

}