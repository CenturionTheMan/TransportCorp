package com.tasnporstcorp.app.orders;

import com.tasnporstcorp.app.users.*;

public class Order {

	private int orderId = -1;
	private Commodity transportedCommodity;
	private User orderer;
	private String prefferedDeliveryDate;
	private OrderStatus status = com.tasnporstcorp.app.orders.Order.OrderStatus.OnTheTable;
	private String senderAddress;
	private String receiverAddress;
	private Vehicle assignedVehicle = null;
	private String rejectionCause = "";

	public Order(Commodity commodity, User orderer, String deliveryDate, String senderAddress, String receiverAddress) {
		transportedCommodity = commodity;
		this.orderer = orderer;
		this.prefferedDeliveryDate = deliveryDate;
		this.senderAddress = senderAddress;
		this.receiverAddress = receiverAddress;
	}

	public void setOrderStatus(OrderStatus status)
	{
		this.status = status;
	}

	public boolean equals(Object o) {
		throw new UnsupportedOperationException();
	}

	public void setId(int newOrderID) {
		orderId = newOrderID;
	}

	public void assignVehicle(Vehicle assignedVehicle) {
		throw new UnsupportedOperationException();
	}

	public Commodity getTransportedCommodity() {
		return this.transportedCommodity;
	}

	public Vehicle getAssignedVehicle() {
		return this.assignedVehicle;
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public OrderStatus getStatus() {
		return this.status;
	}

	public String getRejectionCause() {
		return this.rejectionCause;
	}

	public String getSenderAddress() {
		return this.senderAddress;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}

	public void acceptOrder() {
		throw new UnsupportedOperationException();
	}

	public void rejectOrder(String rejectionCause) {
		throw new UnsupportedOperationException();
	}

	public void setInProgress() {
		throw new UnsupportedOperationException();
	}

	public void setDelivered() {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.orderId;
	}


	public enum OrderStatus {
		OnTheTable,
		InProgress,
		Rejected,
		Accepted,
		Delivered
	}

}