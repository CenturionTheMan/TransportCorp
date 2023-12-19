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

	/**
	 * 
	 * @param vehicleId
	 * @param driver
	 * @param name
	 * @param capacityCm3
	 */
	public Vehicle(int vehicleId, User driver, String name, double capacityCm3) {
		// TODO - implement Vehicle.Vehicle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param position
	 * @param pointAddress
	 */
	public void addPointToRoute(int position, String pointAddress) {
		// TODO - implement Vehicle.addPointToRoute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param position
	 * @param pointAddress
	 */
	public void removePointFromRoute(int position, String pointAddress) {
		// TODO - implement Vehicle.removePointFromRoute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pointPosition
	 */
	public void modifyPointFromRoute(int pointPosition) {
		// TODO - implement Vehicle.modifyPointFromRoute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public boolean addOrder(Order order) {
		// TODO - implement Vehicle.addOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param order
	 */
	public void removeOrder(Order order) {
		// TODO - implement Vehicle.removeOrder
		throw new UnsupportedOperationException();
	}

}