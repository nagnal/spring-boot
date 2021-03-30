package com.perf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perf.demo.model.Product;
import com.perf.demo.service.ShoppingService;

@RestController
public class ShoppingController {

	private final ShoppingService shoppingService;

	@Autowired
	public ShoppingController(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getDiscount(@RequestParam(required = true) String type) throws Exception {

		Product product = new Product();
		product.setType(type);

		shoppingService.getProductDiscount(product);

		return product;
	}
	
	
	@RequestMapping(value = "/getDiscount", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Product getDiscount(@RequestBody Product product) {
		shoppingService.getProductDiscount(product);
		
		return product;
	}

	
	@RequestMapping(value = "/getDiscounts", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<Product> getDiscounts(@RequestBody List<Product> products) {
		shoppingService.getProductDiscount(products);
		
		return products;
	}
}
