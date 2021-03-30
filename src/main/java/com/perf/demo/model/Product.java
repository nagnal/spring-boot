package com.perf.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product {

	private String type;
	private String coupon;
	private double discount;
	private double price;
	private double finalPrice;
	private List<String> firedRules = new ArrayList<String> ();

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the coupon
	 */
	public String getCoupon() {
		return coupon;
	}

	/**
	 * @param coupon the coupon to set
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @return the price
	 */
	@JsonIgnore
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the finalPrice
	 */
	@JsonIgnore
	public double getFinalPrice() {
		return finalPrice;
	}

	/**
	 * @param finalPrice the finalPrice to set
	 */
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
	/**
	 * @return the firedRules
	 */
	public List<String> getFiredRules() {
		return firedRules;
	}

	/**
	 * @param firedRules the firedRules to set
	 */
	public void setFiredRules(List<String> firedRules) {
		this.firedRules = firedRules;
	}

	public void addFiredRules(String ruleName) {
		firedRules.add(ruleName);
	}

	@Override
	public String toString() {
		return "Product [type=" + type + ", coupon=" + coupon + ", discount=" + discount + ", price=" + price
				+ ", finalPrice=" + finalPrice + ", firedRules=" + firedRules + "]";
	}

}