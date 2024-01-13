package com.tasnporstcorp.tests;

import com.tasnporstcorp.app.users.LoggedInUser;
import com.tasnporstcorp.app.users.User;

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

    public Dane() {
        
    }
}
