package com.tasnporstcorp.app;

import java.util.*;
import com.tasnporstcorp.app.users.*;
import com.tasnporstcorp.app.orders.*;

public class Application {

	private DataBaseAPI dataBaseApi;
	private GUIHandler guiHandler;
	private UserCreator userCreator;
	private OrderCreator orderCreator;
	private LoggedInUser currentUser = null;

	public static void main(String[] args) {
		
		Application app = new Application();
		app.createAccount();
		app.login();
		app.placeNewOrder();
	}

	public Application() {
		guiHandler = new GUIHandler();
		dataBaseApi = new DataBaseAPI();
		orderCreator = new OrderCreator(guiHandler, dataBaseApi);
		userCreator = new UserCreator(guiHandler, dataBaseApi);
	}

	public void login() {
		currentUser = userCreator.getCurrentUserFromDataBase("login");
	}

	public void createAccount() {
		ArrayList<String> loginData = guiHandler.getLoginData();
		userCreator.registerNewUser(loginData);
	}

	public void openOrdersList() {
		throw new UnsupportedOperationException();
	}

	public void placeNewOrder() {
		ArrayList<String> formData = guiHandler.getFormData(); 
        orderCreator.createNewOrder(formData, currentUser);
	}

	public void createBill() {
		throw new UnsupportedOperationException();
	}

	public void updateOrderStatus() {
		throw new UnsupportedOperationException();
	}

	public void processOrder() {
		throw new UnsupportedOperationException();
	}

	public void manageOrder() {
		throw new UnsupportedOperationException();
	}

	private void filterOrderList() {
		throw new UnsupportedOperationException();
	}

}