package com.synacy.lesson02.demo;

import com.synacy.lesson02.demo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShippingServiceTest {

	private ShippingService shippingService;

	@Mock SalesOrderService salesOrderService;
	@Mock WarehouseService warehouseService;
	@Mock CustomerNotificationService customerNotificationService;

	@Before
	public void setup() {
		shippingService = new ShippingService();

		shippingService.setSalesOrderService(salesOrderService);
		shippingService.setCustomerNotificationService(customerNotificationService);
		shippingService.setWarehouseService(warehouseService);
	}


	@Test
	public void testShipSalesOrderByBatch_shouldUpdateBatchSalesOrderStatusToShipped()
			throws Exception {
		ShippingBatch shippingBatch = mock(ShippingBatch.class);

		ArrayList<SalesOrder> salesOrders = new ArrayList<>();
		salesOrders.add(mock(SalesOrder.class));
		salesOrders.add(mock(SalesOrder.class));
		when(salesOrderService.fetchSalesOrderDueForShipment(shippingBatch))
				.thenReturn(salesOrders);

		shippingService.shipSalesOrderByBatch(shippingBatch);

		verify(salesOrderService, times(1)).updateStatus(
				ArgumentMatchers.eq(salesOrders.get(0)),
				ArgumentMatchers.eq(SalesOrderStatus.SHIPPED)
		);
		verify(salesOrderService, times(1)).updateStatus(
				ArgumentMatchers.eq(salesOrders.get(1)),
				ArgumentMatchers.eq(SalesOrderStatus.SHIPPED)
		);
	}

	@Test
	public void testShipSalesOrderByBatch_shouldNotifyCustomerOfEachSalesOrderShipped()
			throws Exception {

		ShippingBatch shippingBatch = mock(ShippingBatch.class);

		ArrayList<SalesOrder> salesOrders = new ArrayList<>();
		salesOrders.add(mock(SalesOrder.class));
		salesOrders.add(mock(SalesOrder.class));
		when(salesOrderService.fetchSalesOrderDueForShipment(shippingBatch))
				.thenReturn(salesOrders);

		shippingService.shipSalesOrderByBatch(shippingBatch);

		verify(customerNotificationService, times(1)).notifyCustomer(
				ArgumentMatchers.eq(NotificationType.SALES_ORDER_STATUS),
				ArgumentMatchers.eq(salesOrders.get(0))
				);
		verify(customerNotificationService, times(1)).notifyCustomer(
				ArgumentMatchers.eq(NotificationType.SALES_ORDER_STATUS),
				ArgumentMatchers.eq(salesOrders.get(1))
		);
	}

	@Test
	public void testShipSalesOrderByBatch_shouldUpdateWarehouseInventoryLevelBasedOnShippedItems()
			throws Exception {
		ShippingBatch shippingBatch = mock(ShippingBatch.class);

		FinishedGood finishedGood1 = mock(FinishedGood.class);
		FinishedGood finishedGood2 = mock(FinishedGood.class);
		FinishedGood finishedGood3= mock(FinishedGood.class);

		HashMap<FinishedGood, Integer> salesOrder1ItemCount = new HashMap<>();
		salesOrder1ItemCount.put(finishedGood1, 5);
		salesOrder1ItemCount.put(finishedGood2, 30);

		SalesOrder salesOrder1 = mock(SalesOrder.class);
		when(salesOrder1.getSalesOrderItemCount())
				.thenReturn(salesOrder1ItemCount);

		HashMap<FinishedGood, Integer> salesOrder2ItemCount = new HashMap<>();
		salesOrder2ItemCount.put(finishedGood1, 3);
		salesOrder2ItemCount.put(finishedGood2, 10);
		salesOrder2ItemCount.put(finishedGood3, 50);
		SalesOrder salesOrder2 = mock(SalesOrder.class);
		when(salesOrder2.getSalesOrderItemCount())
				.thenReturn(salesOrder2ItemCount);

		ArrayList<SalesOrder> salesOrders = new ArrayList<>();
		salesOrders.add(salesOrder1);
		salesOrders.add(salesOrder2);
		when(salesOrderService.fetchSalesOrderDueForShipment(shippingBatch))
				.thenReturn(salesOrders);

		shippingService.shipSalesOrderByBatch(shippingBatch);

		HashMap<FinishedGood, Integer> totalItemsShipped = new HashMap<>();
		totalItemsShipped.put(finishedGood1, 8);
		totalItemsShipped.put(finishedGood2, 40);
		totalItemsShipped.put(finishedGood3, 50);

		verify(warehouseService).updateInventoryLevel(
				ArgumentMatchers.eq(totalItemsShipped)
		);
	}

}