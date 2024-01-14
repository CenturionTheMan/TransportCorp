package com.tasnporstcorp.app.users;

import com.tasnporstcorp.app.*;
import com.tasnporstcorp.app.users.User.UserRole;
import java.util.*;

public class UserCreator {

	private DataBaseAPI dataBaseApi;
	private GUIHandler guiHandler;

	public UserCreator(GUIHandler guiHandler, DataBaseAPI dataBaseApi) {
		this.dataBaseApi = dataBaseApi;
		this.guiHandler = guiHandler;
	}

	public User registerNewUser(ArrayList<String> loginData, String userKey)
	{
		boolean isUserInDatabase = dataBaseApi.checkIfAccountExists(loginData);
		if(isUserInDatabase) {
			return null;
		}

		User user = new User(loginData.get(0), loginData.get(1), loginData.get(2));
		KeyHandler.assignRoleFromKey(user, userKey);

		dataBaseApi.postNewUser(user);
		return user;
	}

	public User registerNewUser(ArrayList<String> loginData) {
		boolean isUserInDatabase = dataBaseApi.checkIfAccountExists(loginData);
		if(isUserInDatabase) {
			guiHandler.showDialogBox("Konto o danym loginie już istnieje");
			return null;
		}

		User user = new User(loginData.get(0), loginData.get(1), loginData.get(2));
		UserRole role = UserRole.None;
		
		while (role == UserRole.None) {
			String userKey = "123";//guiHandler.showDialogBox("Wprowadź klucz dostępu.");
			KeyHandler.assignRoleFromKey(user, userKey);
			role = user.getRole();
			if(role == UserRole.None)
				guiHandler.showMessageBox("Podany klucz jest błędny.");
		}

		guiHandler.showMessageBox("Dodano nowe konto użytkownika!");
		dataBaseApi.postNewUser(user);
		return user;
	}

	public LoggedInUser getCurrentUserFromDataBase(String login) {
		return new LoggedInUser(dataBaseApi.getAccount(login)); 		
	}

	public User getDriverFromDataBase(String login) {
		var user = dataBaseApi.getAccount(login); 
		
		if(user == null)
			throw new NullPointerException();

		var role = user.getRole();
		
		if(role == UserRole.Driver)
			return user;
		else
			throw new IllegalArgumentException();
	}


	public static class KeyHandler {

		private static final String COORDINATOR_KEY = "123";
		private static final String DRIVER_KEY = "321";

		static void assignRoleFromKey(User user, String key) {
			if(key.equals("")){
				user.setRole(UserRole.Customer);
			}
			else if(key.equals(COORDINATOR_KEY)){
				user.setRole(UserRole.Coordinator);
			}
			else if(key.equals(DRIVER_KEY)){
				user.setRole(UserRole.Driver);
			}
			return;
		}

	}

}