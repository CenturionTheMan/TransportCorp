package com.tasnporstcorp.app.users;

public class User {

	private String login;
	private UserRole role = com.tasnporstcorp.app.users.User.UserRole.None;
	private String firstName;
	private String lastName;

	/**
	 * 
	 * @param login
	 * @param firstName
	 * @param lastName
	 */
	User(String login, String firstName, String lastName) {
		// TODO - implement User.User
		throw new UnsupportedOperationException();
	}

	public String getLogin() {
		return this.login;
	}

	public UserRole getRole() {
		return this.role;
	}

	/**
	 * 
	 * @param role
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}


	public enum UserRole {
		Coordinator,
		Driver,
		Customer,
		None
	}

}