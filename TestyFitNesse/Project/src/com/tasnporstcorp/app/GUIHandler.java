package com.tasnporstcorp.app;

import java.util.Scanner;
import java.util.*;

import com.tasnporstcorp.app.orders.*;

public class GUIHandler {

	public GUIHandler() {
		
	}

	/**
	 * 
	 * @param message
	 */
	public void showMessageBox(String message) {
		Scanner in = new Scanner(System.in);
		System.out.println(message);
		System.out.println("Wprowadź ENTER aby kontynuować...");
		in.nextLine();
	}

	/**
	 * 
	 * @param message
	 */
	public String showDialogBox(String message) {
		Scanner in = new Scanner(System.in);
		System.out.println(message);
		System.out.print("> ");
		return in.nextLine();
	}

	public void showForm() {
		// TODO - implement GUIHandler.showForm
		throw new UnsupportedOperationException();
	}

	public static ArrayList<String> formData = null;
	public ArrayList<String> getFormData() {
		if(formData != null)
			return formData;
		var tmp = new String[]{"paczka", "1", "1", "1", "01-01-2023", "Wrocław, ul. Rynek 4", "Wrocław, ul. Rynek 4"};
		return new ArrayList<String>(Arrays.asList(tmp));
	}

	/**
	 * 
	 * @param order
	 */
	public void showOrderData(Order order) {
		// TODO - implement GUIHandler.showOrderData
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orders
	 */
	public void showOrderList(ArrayList<Order> orders) {
		// TODO - implement GUIHandler.showOrderList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vehicles
	 */
	public void showVehicleList(Vehicle vehicles) {
		// TODO - implement GUIHandler.showVehicleList
		throw new UnsupportedOperationException();
	}

	public static ArrayList<String> loginData = null;
	public ArrayList<String> getLoginData() {
		if (loginData != null) {
			return loginData;
		}
		var tmp = new String[]{"login", "jan", "kowalski"};
		return new ArrayList<String>(Arrays.asList(tmp));
	}

}