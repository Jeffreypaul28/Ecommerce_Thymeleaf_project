package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productDetail")
public class Product {
	
	
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	
	public Integer  getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer  category_id) {
		this.category_id = category_id;
	}
	
  
	
	
	private String pname;
	private int price;
	private String purl;
	private Integer  category_id;
	
	
	
	

}
