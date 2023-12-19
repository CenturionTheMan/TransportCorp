package com.tasnporstcorp.app.orders;
import java.util.*;
import com.tasnporstcorp.app.users.*;

public class Vehicle {

	private int vehicleId;
	private User assignedDriver;
	private ArrayList<String> assignedRoute;
	private String vehicleName;
	private ArrayList<Order> transportedOrders;
	private int capacityCm3;

	public Vehicle(int vehicleId, User driver, String name, double capacityCm3) {
		throw new UnsupportedOperationException();
	}

	public void addPointToRoute(int position, String pointAddress) {
		throw new UnsupportedOperationException();
	}

	public void removePointFromRoute(int position, String pointAddress) {
		throw new UnsupportedOperationException();
	}

	public void modifyPointFromRoute(int pointPosition) {
		throw new UnsupportedOperationException();
	}

	public boolean addOrder(Order order) {
		throw new UnsupportedOperationException();
	}

	public void removeOrder(Order order) {
		throw new UnsupportedOperationException();
	}

}