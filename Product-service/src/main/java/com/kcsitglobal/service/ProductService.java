package com.kcsitglobal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcsitglobal.entity.Product;
import com.kcsitglobal.repository.ProductRespository;

@Service
public class ProductService {

	@Autowired
	private ProductRespository productRepository;

	public Product save(Product product) {
		int qty = product.getQuantity();
		double totalPrice = qty * product.getPrice();
		product.setTotalPrice(totalPrice);
		Product newProduct = productRepository.save(product);
		return newProduct;
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);

	}
}