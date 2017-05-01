package com.synacy.lesson02.demo.domain;

import java.util.Map;

public interface SalesOrder {
	Map<FinishedGood,Integer> getSalesOrderItemCount();
}
