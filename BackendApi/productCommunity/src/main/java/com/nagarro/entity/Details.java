package com.nagarro.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Details {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int detailId;

@ManyToOne
@JoinColumn
@JsonIgnore
private Product product;
private String color;
private String gender;
private String userName;
private String size;
public Details() {
	super();
}
public Details(int detailId, Product product, String color, 
		String userName, String size) {
	super();
	this.detailId = detailId;
	this.product = product;
	this.color = color;
	this.userName = userName;
	this.size = size;
}
public int getDetailId() {
	return detailId;
}
public void setDetailId(int detailId) {
	this.detailId = detailId;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public void setDate(String format) {
	// TODO Auto-generated method stub
	
}


}