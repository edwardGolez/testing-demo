package com.synacy.lesson01.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Invoice {

	private HashSet<InvoiceItem> items;

	public Invoice() {
		this.items = new HashSet<InvoiceItem>();
	}

	public Invoice(Set<InvoiceItem> items) {
		this.items = new HashSet<InvoiceItem>(items);
	}

	public double getTotalAmount() {
		Iterator<InvoiceItem> itemIterator = items.iterator();

		double totalAmount = 0.0;
		while(itemIterator.hasNext()) {
			totalAmount += itemIterator.next().getExtendedPrice();
		}

		return totalAmount;
	}

}
