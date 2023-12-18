package com.tasnporstcorp.app.users;

import com.tasnporstcorp.app.*;

public class UserCreator {

	private DataBaseAPI dataBaseApi;
	private GUIHandler guiHandler;

	/**
	 * 
	 * @param guiHandler
	 * @param dataBaseApi
	 */
	public UserCreator(GUIHandler guiHandler, DataBaseAPI dataBaseApi) {
		// TODO - implement UserCreator.UserCreator
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loginData
	 */
	public void registerNewUser(String[] loginData) {
		// TODO - implement UserCreator.registerNewUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param login
	 */
	public LoggedInUser getCurrentUserFromDataBase(String login) {
		// TODO - implement UserCreator.getCurrentUserFromDataBase
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param login
	 */
	public User getDriverFromDataBase(String login) {
		// TODO - implement UserCreator.getDriverFromDataBase
		throw new UnsupportedOperationException();
	}


	public class KeyHandler {

		private static final String COORDINATOR_KEY = "123";
		private static final String DRIVER_KEY = "123";

		/**
		 * 
		 * @param user
		 * @param key
		 */
		static void assignRoleFromKey(User user, String key) {
			// TODO - implement KeyHandler.assignRoleFromKey
			throw new UnsupportedOperationException();
		}

	}

}