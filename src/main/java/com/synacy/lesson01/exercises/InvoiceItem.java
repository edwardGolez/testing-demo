package com.synacy.lesson01.exercises;

public class InvoiceItem {

	Product product;
	Integer quantity;

	public InvoiceItem() {
		this(null, null);
	}

	public InvoiceItem(Product product, Integer quantity) {
		setProduct(product);
		setQuantity(quantity);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getExtendedPrice() {
		return quantity * product.getUnitPrice();
	}

}
