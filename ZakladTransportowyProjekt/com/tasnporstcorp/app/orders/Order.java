package com.tasnporstcorp.app.orders;

import com.tasnporstcorp.app.users.*;
import com.tasnporstcorp.app.Application.*;
import com.tasnporstcorp.app.orders.transport.*;

public class Order {

	private int orderId = -1;
	public Commodity transportedCommodity;
	public User orderer;
	public string prefferedDeliveryDate;
	private OrderStatus status;
	public string senderAddress;
	public string receiverAddress;
	private Vehicle assignedVehicle = null;

	/**
	 * 
	 * @param commodity
	 * @param orderer
	 * @param deliveryDate
	 * @param senderAddress
	 * @param receiverAddress
	 */
	public Order(Commodity commodity, User orderer, string deliveryDate, string senderAddress, string receiverAddress) {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newOrderID
	 */
	public void setId(int newOrderID) {
		// TODO - implement Order.setId
		throw new UnsupportedOperationException();
	}

	public Vehicle getAssignedVehicle() {
		return this.assignedVehicle;
	}

	/**
	 * 
	 * @param assignedVehicle
	 */
	public void assignVehicle(Vehicle assignedVehicle) {
		// TODO - implement Order.assignVehicle
		throw new UnsupportedOperationException();
	}

	public double gerPrice() {
		// TODO - implement Order.gerPrice
		throw new UnsupportedOperationException();
	}

}