package com.synacy.lesson02.demo;

import com.synacy.lesson02.demo.domain.FinishedGood;

import java.util.Map;

public interface WarehouseService {
	void updateInventoryLevel(Map<FinishedGood, Integer> totalItemsShipped);
}
