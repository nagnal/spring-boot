package com.perf.demo.inputjson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perf.demo.model.Product;

public class ProdValue {
	@JsonProperty("com.perf.demo.model.Product")
	public Product product;
	
//	@JsonProperty("com.perf.demo.model.Jewelry")
//	public Jewelry jewelry;

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	
//	/**
//	 * @return the jewelry
//	 */
//	public Jewelry getJewelry() {
//		return jewelry;
//	}
//
//	/**
//	 * @param jewelry the jewelry to set
//	 */
//	public void setJewelry(Jewelry jewelry) {
//		this.jewelry = jewelry;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProdValue [product=" + product + "]";
	}
}
