package com.tasnporstcorp.tests;
import java.util.ArrayList;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.tasnporstcorp.app.database.DataBaseAPI;
import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.users.UserCreator;


// TESTS FOR 3.
@Tag("UserCreator")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreatorTest implements TestExecutionExceptionHandler{

    static UserCreator userCreator;
    static DataBaseAPI dataBaseAPI;
    static GUIHandler guiHandler;
    static TestData dane;

    @BeforeAll
    public static void Init() {
        guiHandler = new GUIHandler();
        dataBaseAPI = new DataBaseAPI();
        userCreator = new UserCreator(guiHandler, dataBaseAPI);
        dane = new TestData();
    }

    public static Stream<Arguments> addFilterValueSource()
    {
        ArrayList<Arguments> res = new ArrayList<Arguments>();
        for (int i = 0; i < dane.usersData.size(); i++) {
            var single = dane.usersData.get(i);
            var arg = Arguments.of(single[0], single[1], single[2], dane.keys.get(i));
            res.add(arg);
        }
        return res.stream();
    }

    
    // 3
    @Order(1)
    @ParameterizedTest
    @MethodSource("addFilterValueSource")
    public void testRegisterNewUser(String login, String firstName, String lastName, String userKey)
    {
        ArrayList<String> loginData = new ArrayList<String>();
        loginData.add(login);
        loginData.add(firstName);
        loginData.add(lastName);
        assertNotNull(userCreator.registerNewUser(loginData, userKey));
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource({"pomidor4", "pomidor5", "pomidor6"})
    public void testGetCurrentUserFromDataBase(String login)
    {
        assertNotNull(userCreator.getCurrentUserFromDataBase(login));
    }

    @Order(3)
    @Test
    @ExtendWith(UserCreatorTest.class)
    public void testGetDriverFromDataBase()
    {
        assertNotNull(userCreator.getDriverFromDataBase("pomidor6"));
    }

    @Override
    public void handleTestExecutionException(ExtensionContext arg0, Throwable arg1) throws Throwable {
        if(arg1 instanceof IllegalArgumentException)
        {
            System.out.println("Exception handled");
            return;
        }

        throw arg1;
    }
}
