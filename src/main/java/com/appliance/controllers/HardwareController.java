package com.appliance.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appliance.data.CustomerOrders;
import com.appliance.data.Product;
import com.appliance.data.ProductOrders;
import com.appliance.dtos.InventoryDto;
import com.appliance.service.HardwareService;

@RestController
public class HardwareController {

	@Autowired
	HardwareService service;
	

	@Transactional
	@GetMapping(path = "/fillData")
	public void fillData() {
		Product product1 = new Product();
		product1.setProductName("Gaming Keyboard");
		product1.setProductDescription("The best gaming keyboard anyone could have");
		product1.setIsbnNumber("A147258369");
		product1.setPrice(15);
		product1.setProductOnHand(100);
		
		Product product2 = new Product();
		product2.setIsbnNumber("B35496845");
		product2.setPrice(10);
		product2.setProductName("Gaming Mouse");
		product2.setProductDescription("The best gaming mouse anyone could have");
		product2.setProductOnHand(30);

		Product product3 = new Product();
		product3.setProductName("Gaming Monitor");
		product3.setIsbnNumber("C6516981");
		product3.setPrice(80);
		product3.setProductDescription("The best gaming monitor you could have, crisp screens");
		product3.setProductOnHand(80);
		
		//Save Products to database
		service.saveProduct(product1);
		service.saveProduct(product2);
		service.saveProduct(product3);
		
		List<Product> customerOrderProducts = new ArrayList<>();
		List<Product> ownerOrderProducts = new ArrayList<>();
		CustomerOrders order1 = new CustomerOrders();
		customerOrderProducts.add(product1);
		
		order1.setOrderDate(LocalDateTime.now());
		order1.setProducts(customerOrderProducts);
		//Save customer order to database
		service.saveCustomerOrder(order1);
		
		ProductOrders order2 = new ProductOrders();
		ownerOrderProducts.add(product1);
		order2.setOrderDate(LocalDateTime.now());
		order2.setProducts(ownerOrderProducts);
		order2.setCost(350);
		//Save product order to database
		service.saveProductOrder(order2);
	}

	@Transactional
	@GetMapping(path = "/displayInventory")
	public List<InventoryDto> displayInventory() {		
		//gets a list of all products
		List<Product> rawData =	service.getAllProduct();
		List<InventoryDto> inventory = new ArrayList<>();
		
		for(Product product : rawData) {
			InventoryDto dto = new InventoryDto();
			dto.setName(product.getProductName());
			dto.setQuantity(product.getProductOnHand());
			
			inventory.add(dto);
		}
		return inventory;
	}

	@Transactional
	@GetMapping(path = "/getCustomerOrderHistory")
	public List<CustomerOrders> getCustomerOrderHistory() {
		if(!service.getAllCustomerOrder().isEmpty()) {
		return service.getAllCustomerOrder();
		}
		else {
			List<CustomerOrders> listEmpty = new ArrayList<>();
			return listEmpty;
		}
	}
	
	@Transactional
	@GetMapping(path = "/getProductOrderHistory")
	public List<ProductOrders> getProductOrders() {
		if(!service.getAllProductOrders().isEmpty()) {
		return service.getAllProductOrders();
		}
		else {
			List<ProductOrders> listEmpty = new ArrayList<>();
			return listEmpty;
		}
	}

}
