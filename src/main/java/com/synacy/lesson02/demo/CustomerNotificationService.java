package com.synacy.lesson02.demo;

import com.synacy.lesson02.demo.domain.NotificationType;
import com.synacy.lesson02.demo.domain.SalesOrder;

public interface CustomerNotificationService {
	void notifyCustomer(NotificationType salesOrderStatus, SalesOrder salesOrder);
}
