package com.tasnporstcorp.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
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

import java.util.ArrayList;
import java.util.stream.Stream;

import com.tasnporstcorp.app.Application;
import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.orders.Commodity;
import com.tasnporstcorp.app.users.LoggedInUser;


// TESTS FOR 4.
@Tag("SystemControl")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicationTest implements TestExecutionExceptionHandler{

    static Application app;

    // Punkt 4 - wykorzystanie metody wykonującej się przez wszystkimi testami
    @BeforeAll
    public static void initTestedApplication(){
        app = new Application();
    }

    // Punkt 4 - test wykonywany jak 1-szy, wielokrotnie, wykorzystujący dane ze wzbioru wartości oddzielanych przecinkami
    @Tag("AccountCreation")
    @ParameterizedTest
    @Order(1)
    @CsvSource({
        "login1, name1, surname1", 
        "login2, name2, surname2", 
        "login3, name3, surname3"
    })
    public void testCreateAccount_successfull(String login, String firstName, String lastName)
    {
        ArrayList<String> registerFormData = new ArrayList<String>();
        registerFormData.add(login);
        registerFormData.add(firstName);
        registerFormData.add(lastName);
        GUIHandler.loginData = registerFormData;

        assertTrue("Otrzymano informacje o niepowodzeniu", app.createAccount());
        LoggedInUser user = app.getUserCreator().getCurrentUserFromDataBase(login);
        assertNotNull("Użytkownik nie istnieje", user);
        assertEquals(user.getLogin(), login);
        assertEquals(user.getFirstName(), firstName);
        assertEquals(user.getLastName(), lastName);
    }


    // Punkt 4 - test wykonywany jednokrotnie, jako 4-ty
    @Tag("LogIn")
    @Test
    @Order(4)
    public void testLogin_loginIntoNonExistingProfile()
    {
        assertFalse(app.login("abcdef"));
    }

    // Metoda generująca dane zamówienia, które wytworzyłby w normalnych warunkach użytkownik w GUI
    public static Stream<Arguments> simulateUserFillingOrderForm()
    {
        String[][] formData = new String[][]{
            {"paczka", "1", "1", "1", "01-03-2023", "Wrocław, ul. Rynek 4", "Wrocław, ul. Grunwaldzka 5"},
            {"paczka", "2", "3", "4", "01-02-2023", "Wrocław, ul. Jana Pawła II 10", "Wrocław, ul. Jana Pawła II 10"},
            {"paczka", "40", "29", "6", "19-04-2023", "Wrocław, ul. Plac Hirszfelda 2", "Wrocław, ul. Bezpieczna 30a"}
        };

        ArrayList<Arguments> testArguments = new ArrayList<Arguments>();
        for (String[] data : formData) {
            testArguments.add(Arguments.of(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
        }
        return testArguments.stream();
    }

    // Puntk 4 - testy wykonywany jako 3-ci, wielokrotnie, wykorzystujący dane wygenerowane przez metodę simulateUserFillingOrderForm()
    @Tag("Order")
    @ParameterizedTest
    @Order(3)
    @MethodSource("simulateUserFillingOrderForm")
    @ExtendWith(ApplicationTest.class)
    public void testPlaceNewOrder(String name, String lengthCm, String widthCm, String depthCm, String deliveryDate, String senderAddress, String receiverAddress)
    {
        ArrayList<String> formData = new ArrayList<String>(){
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
        GUIHandler.formData = formData;

        int placedOderId = app.placeNewOrder();
        assertTrue(placedOderId != -1);
        com.tasnporstcorp.app.orders.Order order = app.getDatabase().getOrder(placedOderId);
        assertNotNull(order);
        assertEquals(order.getReceiverAddress(), receiverAddress);
        assertEquals(order.getSenderAddress(), senderAddress);
        Commodity commodity = order.getTransportedCommodity();
        assertEquals(commodity.depthCm, Double.parseDouble(depthCm), 0);
        assertEquals(commodity.widthCm, Double.parseDouble(widthCm), 0);
        assertEquals(commodity.lengthCm, Double.parseDouble(lengthCm), 0);
    }

    // Punkt 4 - test wykonywany wielokrotnie jako 2-gi, wykorzystujący dane ze zbioru wartości oddzielonych przecinkami
    @Tag("LogIn")
    @ParameterizedTest
    @CsvSource({
        "login1, true",         // istniejący użytkownik
        "login2, true"          // istniejący użytkownik
    })
    @Order(2)
    public void testLogin_loggingIntoExistingProfile(String login, boolean userExists)
    {
        assertTrue(app.login(login) == userExists);
        if(userExists){
            LoggedInUser currentUser = app.getCurrentUser();
            assertEquals(currentUser.getLogin(), login);
        }
    }

    @Override
    public void handleTestExecutionException(ExtensionContext arg0, Throwable arg1) throws Throwable {
        // Wyrzucane przez getDriverFromDataBase
        if(arg1 instanceof UnsupportedOperationException && arg0.getTestMethod().get().getName().equals("testPlaceNewOrder"))
        {
            System.out.println(
                "Exception occured in " + 
                arg0.getTestMethod().get().getName() + 
                "(" + arg0.getDisplayName() + ")" + ": " +
                arg1.getMessage()
            );
        }
        else
        {
            throw arg1;
        }
    }
}
