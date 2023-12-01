package com.nagarro.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Product {
@Id
@Column(unique=true,columnDefinition="VARCHAR(64)")
private String productCode;
@OneToMany(mappedBy="product",cascade=CascadeType.ALL)
private List<Details> details=new ArrayList<Details>();
private String brand;
private int price;
private String date;
private String userName;
private String imagelink;
private String description;

public Product() {
	super();
}
public Product(String productCode, String brand, int price, String date, String userName) {
	super();
	this.productCode= productCode;
	this.brand = brand;
	this.price=price;
	this.date = date;
	this.userName = userName;
}


public List<Details> getDetails() {
	return details;
}
public void setDetails(List<Details> details) {
	this.details = details;
}
public String getProductCode() {
	return productCode;
}
public void setProductCode(String productcode) {
	this.productCode = productcode;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getImagelink() {
	return imagelink;
}
public void setImagelink(String imagelink) {
	this.imagelink = imagelink;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


}