package com.tasnporstcorp.tests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import org.junit.runners.Parameterized.Parameters;

import com.tasnporstcorp.tests.Dane;

// package com.tasnporstcorp.app.LoggedInUser

public class LoggedInUserTest {

    Dane dane;

    @BeforeAll
    public void init()
    {
        dane = new Dane();
    }

    @Parameters()
    public void testRemoveFilter()
    {
        Dane.loggedInUser[0].
    }    
} 