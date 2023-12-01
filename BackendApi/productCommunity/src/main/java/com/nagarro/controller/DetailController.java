package com.nagarro.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Product;
import com.nagarro.entity.Details;
import com.nagarro.model.Model;
import com.nagarro.service.ProductService;
import com.nagarro.service.RegistrationService;
import com.nagarro.service.DetailService;


@RestController
@CrossOrigin
public class DetailController {

@Autowired
private DetailService  detailService;
@Autowired
private ProductService productService;	
@Autowired
private RegistrationService registrationService;

/*
 * This API is used  to get allDetail with respect productId
 * @Param productId
 * @Return List<Details>
 */
 @GetMapping("/getAllDetails/{id}")
 public List<Details> getAllDetails(@PathVariable(value="id") String id) throws Exception{
	List<Details> results;
	try {
        Product productObj=productService.getProduct(id);
         results=detailService.getAllDetails(productObj);
	}
	catch(Exception e) {
		throw new Exception(e.getMessage());
	}
    return results;
  }

 /*
  * This API is used to store the details with respect prodductId
  * @Param peoductId
  * @Return nothing
  */
 @PutMapping("/insertDetail/{id}")
 public void insertReview(@RequestBody Details detail,@PathVariable(value="id") String id) throws Exception
 {
	Product product;
	List<Details> detail1;
	try {
	   product=productService.getProduct(id);
	   detail1 =product.getDetails();
	   detail1.add(detail);
	   detail.setProduct(product);
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   Date date = new Date();
	   product.setDate(dateFormat.format(date));
	   productService.updateProductReview(product);
	}
	catch(Exception e) {
		throw new Exception(e.getMessage());
	}
 }

/*
 * This API is used to get stats details
 * @Param nothing
 * @Return Model
 */
 @GetMapping("/getstats")
 public Model getStats() throws Exception{
	Model model = new Model();
	try {
	model.countUsers=registrationService.countAllRegistrated();
	model.countComments=detailService.countAllComment();
	model.countPosts=productService.countAllProduct();
	}
	catch(Exception e)
	{
		throw new Exception(e.getMessage());
	}
	return model;	
 }
}
