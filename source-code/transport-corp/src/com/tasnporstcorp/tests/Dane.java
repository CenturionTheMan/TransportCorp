package com.tasnporstcorp.tests;

import java.util.List;

import org.junit.jupiter.params.provider.CsvSource;

import com.tasnporstcorp.app.users.LoggedInUser;
import com.tasnporstcorp.app.users.User;
import java.util.ArrayList;

public class Dane {
    public String[] filterAttributes = {
        "price",
        "deliveryDate",
        "volume",
    };

    public String[] filterConditions = {
        "<",
        ">",
        "=",
    };

    public LoggedInUser loggedInUser = new LoggedInUser("pomidor", User.UserRole.Customer, "Romek", "Kowalski") 
    {
        {
            addFilter("price", "<");
            addFilter("volume", "=");
        }
    };

    
    public String COORDINATOR_KEY = "123";
    public final String DRIVER_KEY = "321";

    public ArrayList<String>[] loginsData;
    public List<String> keys = List.of("123", "321", "");

    public Dane() {
        loginsData = new ArrayList[3];
        loginsData[0] = new ArrayList<String>();
        loginsData[0].add("pomidor4");
        loginsData[0].add("John");
        loginsData[0].add("Doe");

        loginsData[1] = new ArrayList<String>();
        loginsData[1].add("pomidor5");
        loginsData[1].add("Jane");
        loginsData[1].add("Smith");

        loginsData[2] = new ArrayList<String>();
        loginsData[2].add("pomidor6");
        loginsData[2].add("Alice");
        loginsData[2].add("Johnson");
    }
}
