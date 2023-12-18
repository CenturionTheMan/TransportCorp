package com.tasnporstcorp.app.users;

import com.tasnporstcorp.app.users.User.*;

public class LoggedInUser extends User {

	private String[] filtersList;
	private String[] sortingCriteria;

	/**
	 * 
	 * @param login
	 * @param role
	 * @param firstName
	 * @param lastName
	 */
	LoggedInUser(String login, UserRole role, String firstName, String lastName) {
		// TODO - implement LoggedInUser.LoggedInUser
		throw new UnsupportedOperationException();
	}

	public void clearFiltersList() {
		// TODO - implement LoggedInUser.clearFiltersList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param positionOnFiltersList
	 */
	public void removeFilter(int positionOnFiltersList) {
		// TODO - implement LoggedInUser.removeFilter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 * @param condition
	 */
	public void addFilter(String attribute, String condition) {
		// TODO - implement LoggedInUser.addFilter
		throw new UnsupportedOperationException();
	}

	public String[] getFiltersList() {
		return this.filtersList;
	}

	/**
	 * 
	 * @param attribute
	 * @param ascending
	 */
	public void setSortingCriteria(String attribute, boolean ascending) {
		// TODO - implement LoggedInUser.setSortingCriteria
		throw new UnsupportedOperationException();
	}

}