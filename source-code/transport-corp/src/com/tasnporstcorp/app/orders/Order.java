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

	/**
	 * 
	 * @param commodity
	 * @param orderer
	 * @param deliveryDate
	 * @param senderAddress
	 * @param receiverAddress
	 */
	public Order(Commodity commodity, User orderer, String deliveryDate, String senderAddress, String receiverAddress) {
		transportedCommodity = commodity;
		this.orderer = orderer;
		this.prefferedDeliveryDate = deliveryDate;
		this.senderAddress = senderAddress;
		this.receiverAddress = receiverAddress;
	}

	/**
	 * 
	 * @param o
	 */
	public boolean equals(Object o) {
		// TODO - implement Order.equals
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newOrderID
	 */
	public void setId(int newOrderID) {
		orderId = newOrderID;
	}

	/**
	 * 
	 * @param assignedVehicle
	 */
	public void assignVehicle(Vehicle assignedVehicle) {
		// TODO - implement Order.assignVehicle
		throw new UnsupportedOperationException();
	}

	public Commodity getTransportedCommodity() {
		return this.transportedCommodity;
	}

	public Vehicle getAssignedVehicle() {
		return this.assignedVehicle;
	}

	public double getPrice() {
		// TODO - implement Order.getPrice
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
		// TODO - implement Order.acceptOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param rejectionCause
	 */
	public void rejectOrder(String rejectionCause) {
		// TODO - implement Order.rejectOrder
		throw new UnsupportedOperationException();
	}

	public void setInProgress() {
		// TODO - implement Order.setInProgress
		throw new UnsupportedOperationException();
	}

	public void setDelivered() {
		// TODO - implement Order.setDelivered
		throw new UnsupportedOperationException();
	}


	public enum OrderStatus {
		OnTheTable,
		InProgress,
		Rejected,
		Accepted,
		Delivered
	}

}