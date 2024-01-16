package com.tasnporstcorp.test.data;

import java.util.List;

import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.database.DataBaseAPI;
import com.tasnporstcorp.app.users.UserCreator;

import java.util.ArrayList;

public class TestDataUserCreator {
    // Klucze rejestracji
    public final String COORDINATOR_KEY = "123";
    public final String DRIVER_KEY = "321";
    public List<String> keys = List.of(COORDINATOR_KEY, DRIVER_KEY, "");

    // Dane użytkowników
    public ArrayList<String[]> registerData;

    // Moduły testowe
    public DataBaseAPI dataBaseAPI = new DataBaseAPI();
    public GUIHandler guiHandler = new GUIHandler();
    public UserCreator userCreator = new UserCreator(guiHandler, dataBaseAPI);

    public TestDataUserCreator() {
        registerData = new ArrayList<>();
        registerData.add(new String[]{"pomidor4", "John", "Doe"});
        registerData.add(new String[]{"pomidor5", "Jane", "Smith"});
        registerData.add(new String[]{"pomidor6", "Alice", "Johnson"});
    }
}
