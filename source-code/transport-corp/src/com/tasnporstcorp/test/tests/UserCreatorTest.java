package com.tasnporstcorp.test.tests;
import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.tasnporstcorp.app.users.LoggedInUser;
import com.tasnporstcorp.app.users.User;
import com.tasnporstcorp.test.data.TestDataUserCreator;

import static org.junit.jupiter.api.Assertions.*;


// TESTS FOR 3.
@Tag("Factory")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserCreatorTest implements TestExecutionExceptionHandler{

    static TestDataUserCreator testData;

    // Punkt 3 - wykorzystanie metody wykonującej się przez wszystkimi testami
    @BeforeAll
    public static void initTestData() {
        testData = new TestDataUserCreator();
    }

    // Punkt 3 - metoda generująca dane logowania użytkowników
    public static Stream<Arguments> getTestRegisterData()
    {
        ArrayList<Arguments> registerData = new ArrayList<Arguments>();
        for (int i = 0; i < testData.registerData.size(); i++) {
            var userRegisterData = testData.registerData.get(i);
            var testParameters = Arguments.of(userRegisterData[0], userRegisterData[1], userRegisterData[2], testData.keys.get(i));
            registerData.add(testParameters);
        }
        return registerData.stream();
    }

    // Punkt 3 - test wykonywany wielokrotnie, którego parametry wyznacza metoda getTestRegisterData (wykonywany jako 1-szy)
    @Tag("AccountCreation")
    @Order(1)
    @ParameterizedTest
    @MethodSource("getTestRegisterData")
    public void testRegisterNewUser_succesfull(String login, String firstName, String lastName, String userKey)
    {
        ArrayList<String> registerData = new ArrayList<String>();
        registerData.add(login);
        registerData.add(firstName);
        registerData.add(lastName);

        User registeredUser = testData.userCreator.registerNewUser(registerData, userKey);
        assertNotNull(registeredUser);
        assertEquals(registeredUser.getLogin(), login, "Zapisano niepoprawny login");
        assertEquals(registeredUser.getFirstName(), firstName, "Zapisano niepoprawne imię");
        assertEquals(registeredUser.getLastName(), lastName, "Zapisano niepoprawne nazwisko");
    }

    // Punkt 3 - test wykonywany wielokrotnie, którego parametry wyznacza lista wartości oddzielonyc przecinkami (wykonywany jako 2-gi)
    @Tag("LogIn")
    @Order(2)
    @ParameterizedTest
    @CsvSource({
        "pomidor4, true", 
        "pomidor5, true", 
        "pomidor6, true",
        "xyz, false"
    })
    public void testGetCurrentUserFromDataBase(String login, boolean userShouldExist)
    {
        LoggedInUser currentUser = testData.userCreator.getCurrentUserFromDataBase(login);

        if(userShouldExist){
            assertNotNull(currentUser, "Nie udało sie pobrać użytkownika");
            assertEquals(login, currentUser.getLogin(), "Niepoprawny login");
        }
        else{
            assertNull(currentUser);
        }
    }

    // Punkt 3 - test oznaczony adnotacją @Test, wykonywany jako 3-ci
    @Tag("UserRetrieving")
    @Order(3)
    @Test
    @ExtendWith(UserCreatorTest.class)
    public void testGetDriverFromDataBase_successfull()
    {
        String driverLogin = testData.registerData.get(testData.keys.indexOf(testData.DRIVER_KEY))[0];
        User userFromDatabase = testData.userCreator.getDriverFromDataBase(driverLogin);

        assertNotNull(userFromDatabase, "Nie pobrano użytkownika");
        assertEquals(userFromDatabase.getRole(), User.UserRole.Driver, "Użytkownik nie jest kierowcą");
        assertEquals(userFromDatabase.getLogin(), driverLogin, "Użytkownik nie ma popawnego loginu");
    }

    public static Stream<String> getNonDriverLogins(){
        ArrayList<String> logins = new ArrayList<>();
        int indexOfDriverLogin = testData.keys.indexOf(testData.DRIVER_KEY);
        for(int i = 0; i < testData.registerData.size(); i++)
            if (i != indexOfDriverLogin)
                logins.add(testData.registerData.get(i)[0]);
        logins.add("xyzsada");
        return logins.stream();
    }

    // Punkt 3 - test oznaczony adnotacją @Test, wykonywany jako 3-ci
    @Tag("UserRetrieving")
    @Order(4)
    @ParameterizedTest
    @MethodSource("getNonDriverLogins")
    @ExtendWith(UserCreatorTest.class)
    public void testGetDriverFromDataBase_unsuccessfull(String nonDriverLogin)
    {
        User userFromDatabase = testData.userCreator.getDriverFromDataBase(nonDriverLogin);

        assertNotNull(userFromDatabase, "Nie pobrano użytkownika");
        assertEquals(userFromDatabase.getRole(), User.UserRole.Driver, "Użytkownik nie jest kierowcą");
        assertEquals(userFromDatabase.getLogin(), nonDriverLogin, "Użytkownik nie ma popawnego loginu");
    }

    // Punkt 2 - obsługa wyjątków
    @Override
    public void handleTestExecutionException(ExtensionContext arg0, Throwable arg1) throws Throwable {
        // Wyrzucane przez getDriverFromDataBase
        if(arg1 instanceof IllegalArgumentException && arg0.getTestMethod().get().getName().equals("testGetDriverFromDataBase_unsuccessfull"))
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
