package com.tasnporstcorp.app;

import com.tasnporstcorp.app.users.*;
import com.tasnporstcorp.app.orders.*;

public class Application {

	private User currentUser = null;
	private DataBaseAPI dataBaseApi;
	private GUIHandler guiHandler;
	private UserCreator userCreator;
	private OrderCreator orderCreator;

	public Application() {
		// TODO - implement Application.Application
		throw new UnsupportedOperationException();
	}

	public void login() {
		// TODO - implement Application.login
		throw new UnsupportedOperationException();
	}

	public void createAccount() {
		// TODO - implement Application.createAccount
		throw new UnsupportedOperationException();
	}

	public void openOrdersList() {
		// TODO - implement Application.openOrdersList
		throw new UnsupportedOperationException();
	}

	public void placeNewOrder() {
		// TODO - implement Application.placeNewOrder
		throw new UnsupportedOperationException();
	}

	public void createBill() {
		// TODO - implement Application.createBill
		throw new UnsupportedOperationException();
	}

	public void updateOrderStatus() {
		// TODO - implement Application.updateOrderStatus
		throw new UnsupportedOperationException();
	}

	public void processOrder() {
		// TODO - implement Application.processOrder
		throw new UnsupportedOperationException();
	}

	public void manageOrder() {
		// TODO - implement Application.manageOrder
		throw new UnsupportedOperationException();
	}

	public static void main() {
		// TODO - implement Application.main
		throw new UnsupportedOperationException();
	}


	public enum UserRole {
		;

		public int Coordinator;
		public int Driver;
		public int Customer;

	}


	public enum OrderStatus {
		;

		int OnTheTable;
		int InProgress;
		int Rejected;
		int Accepted;
		int Delivered;

	}

}