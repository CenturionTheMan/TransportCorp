package com.tasnporstcorp.app;

import com.tasnporstcorp.app.orders.*;
import com.tasnporstcorp.app.users.*;

public class DataBaseAPI {

	public DataBaseAPI() {
		// TODO - implement DataBaseAPI.DataBaseAPI
		throw new UnsupportedOperationException();
	}

	public int getNextOrderId() {
		// TODO - implement DataBaseAPI.getNextOrderId
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderToCheck
	 */
	public boolean checkIfOrderExists(Order orderToCheck) {
		// TODO - implement DataBaseAPI.checkIfOrderExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public boolean postNewOrder(Order order) {
		// TODO - implement DataBaseAPI.postNewOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loginData
	 */
	public boolean checkIfAccountExists(String[] loginData) {
		// TODO - implement DataBaseAPI.checkIfAccountExists
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 */
	public boolean postNewUser(User user) {
		// TODO - implement DataBaseAPI.postNewUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param parameter
	 */
	public void updateVehicleRoute(Vehicle parameter) {
		// TODO - implement DataBaseAPI.updateVehicleRoute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderId
	 */
	public Order getOrder(int orderId) {
		// TODO - implement DataBaseAPI.getOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param currentUser
	 */
	public Order[] getOrdersForUser(LoggedInUser currentUser) {
		// TODO - implement DataBaseAPI.getOrdersForUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public void updateOrder(Order order) {
		// TODO - implement DataBaseAPI.updateOrder
		throw new UnsupportedOperationException();
	}

	public Vehicle[] getAllVehiclesFromDataBase() {
		// TODO - implement DataBaseAPI.getAllVehiclesFromDataBase
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param login
	 */
	public User getAccount(String login) {
		// TODO - implement DataBaseAPI.getAccount
		throw new UnsupportedOperationException();
	}

}