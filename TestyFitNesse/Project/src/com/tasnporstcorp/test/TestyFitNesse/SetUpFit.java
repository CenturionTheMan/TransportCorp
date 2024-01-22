package com.tasnporstcorp.test.TestyFitNesse;

import com.tasnporstcorp.app.Application;

import fit.Fixture;

public class SetUpFit extends Fixture{
    
    public static Application application;

    public SetUpFit() {
        application = new Application();
    }
}
