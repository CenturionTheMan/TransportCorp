package com.tasnporstcorp.tests;

import java.util.List;

import com.tasnporstcorp.app.database.Filter;
import com.tasnporstcorp.app.users.LoggedInUser;
import com.tasnporstcorp.app.users.User;
import java.util.ArrayList;

public class TestData {
    // Używane w testach atrybuty, po których filtrowano
    public String[] testFilterAttributes = {
        Filter.ORDER_PRICE,
        Filter.ORDER_NAME,
        Filter.COMMODITY_VOLUME,
        "asada",
        Filter.ORDER_DELIVERY_DATE,
        "123"
    };

    // Używane w testach kryteria filtrowania
    public String[] filterConditions = {
        Filter.LESS,
        Filter.GREATER,
        "+",
        Filter.EQUAL,
        Filter.GREATER_EQUAL,
        "ascending",
        "condition",
        Filter.LESS_EQUAL
    };

    // Testowy użytkownik ze zdefiniowanym 3 filtrami
    public LoggedInUser userWith3Filters = new LoggedInUser("pomidor45", User.UserRole.Customer, "Romek", "Kowalski") 
    {
        {
            addFilter(Filter.ORDER_PRICE, Filter.GREATER, "1.8");
            addFilter(Filter.ORDER_NAME, Filter.EQUAL, "2.5676");
            addFilter(Filter.ORDER_DELIVERY_DATE, Filter.EQUAL, "01-02-2024");
        }
    };

    // Klucze rejestracji
    public final String COORDINATOR_KEY = "123";
    public final String DRIVER_KEY = "321";
    public List<String> keys = List.of("123", "321", "");

    // Dane użytkowników
    public ArrayList<String[]> usersData;

    public TestData() {
        usersData = new ArrayList<>();
        usersData.add(new String[]{"pomidor4", "John", "Doe"});
        usersData.add(new String[]{"pomidor5", "Jane", "Smith"});
        usersData.add(new String[]{"pomidor6", "Alice", "Johnson"});
    }
}
