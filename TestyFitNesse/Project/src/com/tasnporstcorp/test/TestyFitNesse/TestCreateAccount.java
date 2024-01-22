package com.tasnporstcorp.test.TestyFitNesse;

import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.users.LoggedInUser;

import fit.ColumnFixture;

import java.util.ArrayList;

public class TestCreateAccount extends ColumnFixture{
    public String dane[];

    public boolean testCreateAccount()
    {
        String login = dane[0];
        String firstName = dane[1];
        String lastName = dane[2];
        ArrayList<String> registerFormData = new ArrayList<String>();
        registerFormData.add(login);
        registerFormData.add(firstName);
        registerFormData.add(lastName);
        GUIHandler.loginData = registerFormData;

        boolean isCreated =  SetUpFit.application.createAccount();

        LoggedInUser user = SetUpFit.application.getUserCreator().getCurrentUserFromDataBase(login);
        boolean isNotNull = user != null ;

        // assertEquals(user.getLogin(), login);
        // assertEquals(user.getFirstName(), firstName);
        // assertEquals(user.getLastName(), lastName);
        return isCreated && isNotNull;
    }
}
