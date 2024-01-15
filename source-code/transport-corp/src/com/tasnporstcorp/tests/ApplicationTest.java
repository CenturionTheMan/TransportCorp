package com.tasnporstcorp.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import com.tasnporstcorp.app.Application;
import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.database.DataBaseAPI;
import com.tasnporstcorp.app.users.User;


// TESTS FOR 4.
@Tag("ApplicationTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicationTest implements TestExecutionExceptionHandler{

    static Application app;

    @BeforeAll
    public static void setup()
    {
        app = new Application();
    }

    @Test
    @Order(2)
    public void testLogin()
    {
        boolean result = app.login("login1");
        assertTrue(result);
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource({"login1, name1, surname1", "login2, name2, surname2", "login3, name3, surname3"})
    public void testCreateAccount(String login, String firstName, String lastName)
    {
        var tmp = new ArrayList<String>();
        tmp.add(login);
        tmp.add(firstName);
        tmp.add(lastName);
        GUIHandler.loginData = tmp;
        assertTrue(app.createAccount());
    }

    public static Stream<Arguments> placeNewOrderSource()
    {
        var tmp = new String[][]{
            {"paczka", "1", "1", "1", "01-03-2023", "Wrocław, ul. Rynek 4", "Wrocław, ul. Grunwaldzka 5"},
            {"paczka", "2", "3", "4", "01-02-2023", "Wrocław, ul. Jana Pawła II 10", "Wrocław, ul. Jana Pawła II 10"},
            {"paczka", "40", "29", "6", "19-04-2023", "Wrocław, ul. Plac Hirszfelda 2", "Wrocław, ul. Bezpieczna 30a"}};

        ArrayList<Arguments> args = new ArrayList<Arguments>();
        for (String[] strings : tmp) {
            args.add(Arguments.of(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]));
        }
        return args.stream();
    }

    @ParameterizedTest
    @Order(3)
    @MethodSource("placeNewOrderSource")
    @ExtendWith(ApplicationTest.class)
    public void testPlaceNewOrder(String name, String lengthCm, String widthCm, String depthCm, String deliveryDate, String senderAddress, String receiverAddress)
    {
        ArrayList<String> tmp = new ArrayList<String>(){
            {
                add(name);
                add(lengthCm);
                add(widthCm);
                add(depthCm);
                add(deliveryDate);
                add(senderAddress);
                add(receiverAddress);
            }
        };
        GUIHandler.formData = tmp;
        app.placeNewOrder();
    }

    @Override
    public void handleTestExecutionException(ExtensionContext arg0, Throwable arg1) throws Throwable {
        if(arg1 instanceof UnsupportedOperationException)
            System.out.println("EXCEPTION in test of" + arg0.getTestMethod() + "(" + arg0.getDisplayName() + ")" + ": " + arg1.getMessage());
        else
            throw arg1;

    }
}
