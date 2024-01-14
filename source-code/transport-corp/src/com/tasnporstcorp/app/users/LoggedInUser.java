package com.tasnporstcorp.app.users;
import java.util.*;
public class LoggedInUser extends User {

	private ArrayList<String> filtersList;
	private ArrayList<String> sortingCriteria;

	/**
	 * 
	 * @param login
	 * @param role
	 * @param firstName
	 * @param lastName
	 */
	public LoggedInUser(String login, UserRole role, String firstName, String lastName) {
		super(login, firstName, lastName);
		filtersList = new ArrayList<>();
		sortingCriteria = new ArrayList<>();
	}

	public LoggedInUser(User user) {
		super(user.getLogin(), user.getFirstName(), user.getLastName());
		filtersList = new ArrayList<>();
		sortingCriteria = new ArrayList<>();
	}

	public void clearFiltersList() {
		filtersList.clear();		
	}

	/**
	 * 
	 * @param positionOnFiltersList
	 */
	public void removeFilter(int positionOnFiltersList) throws IllegalArgumentException{
		if(positionOnFiltersList < 0 || positionOnFiltersList >= filtersList.size())
			throw new IllegalArgumentException();

		filtersList.remove(positionOnFiltersList);
	}

	/**
	 * 
	 * @param attribute
	 * @param condition
	 */
	public void addFilter(String attribute, String condition) {
		filtersList.add(attribute + ": " + condition);
	}

	public ArrayList<String> getFiltersList() {
		return this.filtersList;
	}

	/**
	 * 
	 * @param attribute
	 * @param ascending
	 */
	public void setSortingCriteria(String attribute, boolean ascending) {
		sortingCriteria.add(attribute);
		sortingCriteria.sort((x, y) -> x.compareTo(y));
	}

}