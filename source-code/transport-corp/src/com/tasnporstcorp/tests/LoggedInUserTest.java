package com.tasnporstcorp.tests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.tasnporstcorp.tests.Dane;

// package com.tasnporstcorp.app.LoggedInUser

public class LoggedInUserTest {

    Dane dane;

    @BeforeAll
    public void init()
    {
        dane = new Dane();
    }

    @ParameterizedTest()
    @ValueSource(dane.filterAttributes[0], dane.filterConditions[0])
    public void testAddFilter(String attribute, String condition)
    {
        dane.loggedInUser[0].addFilter(attribute, condition);        
    }

    @ParameterizedTest(name = "Test {index} => {arguments}")
    public void testRemoveFilter()
    {

    }    
} 