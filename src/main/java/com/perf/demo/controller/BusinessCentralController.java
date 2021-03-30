package com.perf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perf.demo.model.Product;
import com.perf.demo.service.RedHatRulesService;

@RestController
public class BusinessCentralController {

	@Autowired private RedHatRulesService redHatRulesService;
	
	@RequestMapping(value = "/business-central/getDiscount", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Product getDiscount(@RequestBody Product product) {
		Object retValue =  redHatRulesService.fireRules(product);

		return (Product) retValue;
	}

	@RequestMapping(value = "/business-central/getDiscounts", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<Product> getDiscounts(@RequestBody List<Product> products) {
		List<Product> returnValues = redHatRulesService.fireRules(products);
		
		return returnValues;
	}
}
