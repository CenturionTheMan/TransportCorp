package com.tasnporstcorp.tests;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.tasnporstcorp.app.DataBaseAPI;
import com.tasnporstcorp.tests.Dane;

public class LoggedInUserTest {

    static Dane dane;

    @BeforeAll
    public static void init()
    {
        dane = new Dane();
    }

    public static Stream<Arguments> testAddFilterValue()
    {
        ArrayList<Arguments> res = new ArrayList<Arguments>();

        for (int i = 0; i < dane.filterAttributes.length; i++) {
            for (int j = 0; j < dane.filterConditions.length; j++) {
                res.add(Arguments.of(dane.filterAttributes[i], dane.filterConditions[j]));
            }
        }

        return res.stream();
    }

    @ParameterizedTest()
    @MethodSource("testAddFilterValue")
    public void testAddFilter(String attribute, String condition)
    {
        dane.loggedInUser[0].addFilter(attribute, condition);        
    }

    // @ParameterizedTest(name = "Test {index} => {arguments}")
    // public void testRemoveFilter()
    // {
        
    // }    
} 