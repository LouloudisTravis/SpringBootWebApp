package com.appliance.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
public class ProductOrders {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int productOrderId;
	
	@Column(name="cost")
	private int cost;
	
	@Column(name="orderDate")
	private LocalDateTime orderDate;
	
	@OneToMany(targetEntity= Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "CustOrder_Product", referencedColumnName = "id")
	private List<Product> products;

	public int getCost() {
		return cost;
	}

	public void setCost(int amount) {
		this.cost = amount;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
