package com.tasnporstcorp.app;
import java.util.*;
import com.tasnporstcorp.app.orders.*;
import com.tasnporstcorp.app.users.*;

public class DataBaseAPI {

	public DataBaseAPI() {
		
	}

	public int getNextOrderId() {
		return 1;
	}

	/**
	 * 
	 * @param orderToCheck
	 */
	public boolean checkIfOrderExists(Order orderToCheck) {
		return false;
	}

	/**
	 * 
	 * @param order
	 */
	public boolean postNewOrder(Order order) {
		return true;
	}

	/**
	 * 
	 * @param loginData
	 */
	public boolean checkIfAccountExists(ArrayList<String> loginData) {
		return false;
	}

	/**
	 * 
	 * @param user
	 */
	public boolean postNewUser(User user) {
		return true;
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
	public ArrayList<Order> getOrdersForUser(LoggedInUser currentUser) {
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

	public ArrayList<Vehicle> getAllVehiclesFromDataBase() {
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