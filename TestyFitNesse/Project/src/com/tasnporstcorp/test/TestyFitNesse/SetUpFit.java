package com.tasnporstcorp.test.TestyFitNesse;

import com.tasnporstcorp.app.Application;

import fit.Fixture;

public class SetUpFit extends Fixture{
    
    static Application application = new Application();

    public SetUpFit() {
        application = new Application();
    }
}
