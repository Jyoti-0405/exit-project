package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

public Product findByProductCode(String productCode);
}
