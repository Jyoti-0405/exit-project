package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.entity.Product;
import com.nagarro.entity.Details;

public interface DetailRepository extends JpaRepository<Details,Integer> {
public List<Details> findByProduct(Product product);
}
