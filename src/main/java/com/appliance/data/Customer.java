package com.appliance.data;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int customerId;
	
	@Column(name="customerFirstName")
	private String custFirstName;

	@Column(name="customerLastName")
	private String custLastName;
	
	@Column(name="customerEmail")
	private String custEmail;
	
	@OneToMany(targetEntity= CustomerOrders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Cust_Order_FK", referencedColumnName = "id")
	private List<CustomerOrders> orders;

	public int getCustomerId() {
		return customerId;
	}
	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public List<CustomerOrders> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrders> orders) {
		this.orders = orders;
	}
	
}
