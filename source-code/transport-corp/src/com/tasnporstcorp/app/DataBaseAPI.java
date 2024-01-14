package com.tasnporstcorp.app;
import java.util.*;
import com.tasnporstcorp.app.orders.*;
import com.tasnporstcorp.app.users.*;

public class DataBaseAPI {

	private static List<User> users = new ArrayList<>();

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
		
		return users.stream().anyMatch(user -> 
		user.getLogin().equals(loginData.get(0)) 
		&& user.getFirstName().equals(loginData.get(1)) 
		&& user.getLastName().equals(loginData.get(2)));
	}

	public boolean postNewUser(User user) {
		users.add(user);
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
		var tmp = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
		if(tmp.isPresent())
			return tmp.get();
		else
			return null;
	}

}