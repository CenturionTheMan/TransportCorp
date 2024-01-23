package com.tasnporstcorp.test.TestyFitNesse;

import com.tasnporstcorp.app.Application;
import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.users.LoggedInUser;

import fit.ColumnFixture;

import java.util.ArrayList;

public class TestCreateAccount extends ColumnFixture{
    public String dane[];
    Application application = new Application();

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

        boolean isCreated =  application.createAccount();

        LoggedInUser user = application.getUserCreator().getCurrentUserFromDataBase(login);
        boolean isNotNull = user != null ;


        boolean isLoginCorrect = user.getLogin() == login;
        boolean isFirstNameCorrect = user.getFirstName() == firstName;
        boolean isLastNameCorrect = user.getLastName() == lastName;
        return isCreated && isNotNull && isLoginCorrect && isFirstNameCorrect && isLastNameCorrect;
    }
}
