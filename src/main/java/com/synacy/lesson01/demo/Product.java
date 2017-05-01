package com.synacy.lesson01.demo;

public class Product {

	private String description;
	private Double unitPrice;

	public Product() {
		this(null, null);
	}

	public Product(String description, Double unitPrice) {
		setDescription(description);
		setUnitPrice(unitPrice);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		if(unitPrice < 0) {
			throw new IllegalArgumentException("Unit price should not be less than zero");
		}
		this.unitPrice = unitPrice;
	}
}
