package com.synacy.lesson02.demo;

import com.synacy.lesson02.demo.domain.SalesOrder;
import com.synacy.lesson02.demo.domain.SalesOrderStatus;
import com.synacy.lesson02.demo.domain.ShippingBatch;

import java.util.List;

public interface SalesOrderService {

	List<SalesOrder> fetchSalesOrderDueForShipment(ShippingBatch shippingBatch);

	void updateStatus(SalesOrder salesOrder, SalesOrderStatus shipped);

}
