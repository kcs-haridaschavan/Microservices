package com.kcsitglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer> {

}
