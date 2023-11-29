package com.nagarro.controller;
import com.nagarro.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.service.SearchProductService;

@RestController
@CrossOrigin
public class showAllProducts {
	
	@Autowired
	SearchProductService service;
	@GetMapping("/getAllProducts/{userName}")
	public List<Product> getAllProducts(@PathVariable("userName") String userName){
		return service.getAllProducts(userName);	
	}
}
