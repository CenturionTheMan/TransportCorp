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

	public boolean checkIfOrderExists(Order orderToCheck) {
		return false;
	}

	public boolean postNewOrder(Order order) {
		return true;
	}

	public boolean checkIfAccountExists(ArrayList<String> loginData) {
		return false;
	}

	public boolean postNewUser(User user) {
		return true;
	}

	public void updateVehicleRoute(Vehicle parameter) {
		throw new UnsupportedOperationException();
	}

	public Order getOrder(int orderId) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Order> getOrdersForUser(LoggedInUser currentUser) {
		throw new UnsupportedOperationException();
	}

	public void updateOrder(Order order) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Vehicle> getAllVehiclesFromDataBase() {
		throw new UnsupportedOperationException();
	}

	public User getAccount(String login) {
		throw new UnsupportedOperationException();
	}

}