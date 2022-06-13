package com.kcsitglobal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kcsitglobal.entity.ProductReport;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

	@GetMapping("api/products")
	public List<ProductReport> getAllProductReport();

	@GetMapping("api/products/{id}")
	public ProductReport getProductReportById(@PathVariable("id") int id);

}