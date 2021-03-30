package com.perf.demo.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perf.demo.model.Product;

@Service
public class ShoppingService {

	Logger logger = LoggerFactory.getLogger(ShoppingService.class);
	
	@Autowired private RulesService rulesService;
//
//	@Autowired
//	public ShoppingService(KieContainer kieContainer) {
//		this.kieContainer = kieContainer;
//	}

	public Product getProductDiscount(Product product) {
		logger.info(product.toString());
		rulesService.fireRules(product);
		logger.info(product.toString());
		
		return product;
	}
	
	public List<Product> getProductDiscount(List<Product> products) {
		logger.info(" ** BEFORE FIRING THE RULES *** " + Arrays.toString(products.toArray()));
		rulesService.fireRules(products);
		logger.info(" ** AFTER FIRING THE RULES *** " + Arrays.toString(products.toArray()));
		return products;
	}
	

//	public Product getProductDiscount(Product product, boolean value) {
//		KieSession kieSession = kieContainer.newKieSession("ksession-rule");
//		kieSession.insert(product);
//		kieSession.fireAllRules();
//		kieSession.dispose();
//		return product;
//	}
	
	
//	public Product getProductDiscount(Product product) throws IOException {
//		KieBuilder kb = ks.newKieBuilder(getKieFileSystem());
//		kb.buildAll();
//		KieModule kieModule = kb.getKieModule();
//		kieContainer = ks.newKieContainer(kieModule.getReleaseId());
//		
//		StatelessKieSession kieSession = kieContainer.newStatelessKieSession();
//		kieSession.execute(product);
//		return product;
//	}
//	
//	public KieFileSystem getKieFileSystem () throws IOException {
//		KieServices ks = KieServices.Factory.get();
//		KieFileSystem kieFileSystem = ks.newKieFileSystem();
//		kieFileSystem.write(ResourceFactory.newClassPathResource("./rules/rules.xls"));
//		return kieFileSystem;
//	}
}