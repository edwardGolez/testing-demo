package com.synacy.lesson02.demo;

import com.synacy.lesson02.demo.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {

	private SalesOrderService salesOrderService;
	private WarehouseService warehouseService;
	private CustomerNotificationService customerNotificationService;

	public List<SalesOrder> shipSalesOrderByBatch(ShippingBatch shippingBatch) {

		List<SalesOrder> salesOrderForShipment = salesOrderService.fetchSalesOrderDueForShipment(shippingBatch);

		Map<FinishedGood, Integer> totalItemsShipped = new HashMap<FinishedGood, Integer>();
		for(SalesOrder salesOrder: salesOrderForShipment) {
			Map<FinishedGood, Integer> salesOrderItemCount = salesOrder.getSalesOrderItemCount();
			totalItemsShipped.putAll(salesOrderItemCount);

			salesOrderService.updateStatus(salesOrder, SalesOrderStatus.SHIPPED);

			customerNotificationService.notifyCustomer(NotificationType.SALES_ORDER_STATUS, salesOrder);
		}

		warehouseService.updateInventoryLevel(totalItemsShipped);

		return salesOrderForShipment;
	}

	public SalesOrderService getSalesOrderService() {
		return salesOrderService;
	}

	public void setSalesOrderService(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	public CustomerNotificationService getCustomerNotificationService() {
		return customerNotificationService;
	}

	public void setCustomerNotificationService(CustomerNotificationService customerNotificationService) {
		this.customerNotificationService = customerNotificationService;
	}
}
