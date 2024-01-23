package com.tasnporstcorp.test.TestyFitNesse;

import com.tasnporstcorp.app.Application;
import com.tasnporstcorp.app.users.LoggedInUser;
import fit.ColumnFixture;

public class TestLogin extends ColumnFixture {
    public String dane[];
    Application application = new Application();


    public boolean testLogin()
    {
        boolean isLoginSuccess = application.login(dane[0]);
        if (!isLoginSuccess)
            return false;

        LoggedInUser currentUser = application.getCurrentUser();
        return currentUser != null;
    }
}
