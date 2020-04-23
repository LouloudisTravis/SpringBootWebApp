package com.appliance.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appliance.data.CustomerInterface;
import com.appliance.data.CustomerOrders;
import com.appliance.data.CustomerOrdersInterface;
import com.appliance.data.Product;
import com.appliance.data.ProductInterface;
import com.appliance.data.ProductOrders;
import com.appliance.data.ProductOrdersInterface;
import com.appliance.dtos.InventoryDto;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class HardwareService {


	@Autowired
	ProductInterface productInterface;
	
	@Autowired
	CustomerInterface customerInterface;
	
	@Autowired
	CustomerOrdersInterface customerOrdersInterface;
	
	@Autowired
	ProductOrdersInterface productOrdersInterface;
	
	@Transactional
	public void saveProduct(Product product) {
		productInterface.saveAndFlush(product);
	} 
	
	public void saveProductOrder(ProductOrders order) {
		productOrdersInterface.saveAndFlush(order);
	}
	
	@Transactional
	public void saveCustomerOrder(CustomerOrders order) {
		customerOrdersInterface.saveAndFlush(order);
	}

	public List<Product> getAllProduct() {
		return productInterface.findAll();
	}

	public List<CustomerOrders> getAllCustomerOrder() {
		return customerOrdersInterface.findAll();
	}
	public List<ProductOrders> getAllProductOrders(){
		return productOrdersInterface.findAll();
	}
}
