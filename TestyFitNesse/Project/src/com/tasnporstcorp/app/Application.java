package com.tasnporstcorp.app;

import com.tasnporstcorp.app.database.DataBaseAPI;
import com.tasnporstcorp.app.orders.Order;
import com.tasnporstcorp.app.orders.OrderCreator;
import com.tasnporstcorp.app.users.LoggedInUser;
import com.tasnporstcorp.app.users.UserCreator;

import java.util.*;

public class Application {

	private DataBaseAPI dataBaseApi;
	private GUIHandler guiHandler;
	private UserCreator userCreator;
	private OrderCreator orderCreator;
	private LoggedInUser currentUser = null;

	public static void main(String[] args) {
		
		Application app = new Application();
		//app.createAccount();
		//app.login("login");
		//app.placeNewOrder();
	}

	public Application() {
		guiHandler = new GUIHandler();
		dataBaseApi = new DataBaseAPI();
		orderCreator = new OrderCreator(guiHandler, dataBaseApi);
		userCreator = new UserCreator(guiHandler, dataBaseApi);
	}

	public boolean login(String login) {
		currentUser = userCreator.getCurrentUserFromDataBase(login);
		return currentUser != null;
	}

	public boolean createAccount() {
		ArrayList<String> loginData = guiHandler.getLoginData();
		//var user = userCreator.registerNewUser(loginData);
		var user = userCreator.registerNewUser(loginData, "123");
		return user != null;
	}

	public void openOrdersList() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Zamieszcza nowe zamóienie w bazie danych.
	 * @return Numer nowego zamówienia bądź -1 w przypadku niepowodzenia.
	 */
	public int placeNewOrder() {
		ArrayList<String> formData = guiHandler.getFormData(); 
        return orderCreator.createNewOrder(formData, currentUser);
	}

	public void createBill() {
		throw new UnsupportedOperationException();
	}

	public boolean updateOrderStatus(int orderId, Order.OrderStatus status) {
		var order = dataBaseApi.getOrder(orderId);
		if(order == null) return false;

		order.setOrderStatus(status);
		return true;
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

	public DataBaseAPI getDatabase(){
		return dataBaseApi;
	}

	public UserCreator getUserCreator(){
		return userCreator;
	}

	public LoggedInUser getCurrentUser(){
		return currentUser;
	}

}