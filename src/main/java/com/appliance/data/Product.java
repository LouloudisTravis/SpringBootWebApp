package com.appliance.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int productId;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="productDescription")
	private String productDescription;
	
	@Column(name="productISBN")
	private String isbnNumber;
	
	@Column(name="price")
	private int price;
	
	@Column(name="prodOnHand")
	private int productOnHand;
	

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductOnHand() {
		return productOnHand;
	}

	public void setProductOnHand(int productOnHand) {
		this.productOnHand = productOnHand;
	}
}
