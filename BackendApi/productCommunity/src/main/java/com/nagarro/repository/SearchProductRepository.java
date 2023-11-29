package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Product;

@Repository
public interface SearchProductRepository extends JpaRepository<Product,Integer> {

	@Query("SELECT p from Product p Where INSTR(Concat(p.productCode,p.brand,p.price),:search)>0 or INSTR(Concat(p.productCode,p.price,p.brand),:search)>0 or INSTR(Concat(p.brand,p.productCode,p.price),:search)>0 or INSTR(Concat(p.brand,p.price,p.productCode),:search)>0 or INSTR(Concat(p.price,p.productCode,p.brand),:search)>0 or INSTR(Concat(p.price,p.brand,p.productCode),:search)>0 ")
    public List<Product> findBySearch(@Param("search")String search);

	//For showing all questions
	@Query("select p from Product p where p.userName=:userName")
	public List<Product> findByUserName(@Param("userName") String userName);
}
