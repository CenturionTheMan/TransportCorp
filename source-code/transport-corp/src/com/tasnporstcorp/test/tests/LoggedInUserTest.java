package com.tasnporstcorp.test.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.tasnporstcorp.app.database.Filter;
import com.tasnporstcorp.app.users.LoggedInUser;
import com.tasnporstcorp.app.users.User.UserRole;
import com.tasnporstcorp.test.data.TestDataLoggedInUser;

@Tag("Users")
public class LoggedInUserTest implements TestExecutionExceptionHandler{     // test implementuje niestandardową obsługę wyjątków

    static TestDataLoggedInUser testData;

    // Punkt 2 - wykorzystanie metody wykonującej się przez każdym testem
    @BeforeEach 
    public void prepareForNextTest()
    {
        testData = new TestDataLoggedInUser();
    }

    // Punkt 2 - metoda wykorzystująca adnotację @Test
    @Tag("Filters")
    @Test
    public void testGetFiltersList_listEmpty(){
        ArrayList<String> filtersList = testData.userWithNoFilters.getFiltersList();
        assertNotNull(filtersList);
        assertEquals(filtersList.size(), 0);
    }

    // Punkt 2 - metoda generująca dane nt. filtrów ustalonych przez użytkownika w GUI
    public static Stream<Arguments> getTestFilters()
    {
        ArrayList<Arguments> filters = new ArrayList<Arguments>();
        for (String filterAttribute : testData.testFilterAttributes) 
            for(String filterCondition : testData.filterConditions)
                for(String filterValue : testData.filterConditionsValues)
                    filters.add(Arguments.of(filterAttribute, filterCondition, filterValue));
        return filters.stream();
    }

    // Punkt 2 - wykorzystane testy wielokrotne, wykorzystujące dane generowane za pomocą metody "getTestFilters()"
    @Tag("Filters")
    @ParameterizedTest
    @MethodSource("getTestFilters")
    @ExtendWith(LoggedInUserTest.class)
    public void testAddFilter(String attribute, String condition, String filterValue)
    {
        LoggedInUser testUser = new LoggedInUser("X", UserRole.Customer, "xyz", "abc");
        int sizeBeforeAddition = testUser.getFiltersList().size();
        assertTrue(testUser.addFilter(attribute, condition, filterValue));

        assertEquals(sizeBeforeAddition+1, testUser.getFiltersList().size(), "Lista filtrów powinna się powiększyć");
        assertTrue(testUser.getFiltersList().contains(new String(attribute+";"+condition+";"+filterValue)));
    }

    // Punkt 2 - wykorzystane testy wielokrotne, wykorzystujące dane generowane z wartości oddzielanych przecinkami
    @ParameterizedTest
    @ExtendWith(LoggedInUserTest.class)
    @CsvSource({
        "100",      // za duży indeks  
        "1",        // dobry indeks
        "0",        // dobry indeks
        "-1"        // za mały indeks
    })
    public void testRemoveFilter(int indexOfFilter)
    {
        int sizeBeforeDeletion = testData.userWith3Filters.getFiltersList().size();
        boolean indexIsValid = 0 <= indexOfFilter && indexOfFilter < sizeBeforeDeletion;

        assertEquals(testData.userWith3Filters.removeFilter(indexOfFilter), indexIsValid);
        if(indexIsValid)
            assertEquals(sizeBeforeDeletion-1, testData.userWith3Filters.getFiltersList().size());
    }

    // Punkt 2 - wykorzystanie adnotacji @Test do sprawdzenia działania metody
    @Tag("Filters")
    @Test
    public void testGetFiltersList_listNotEmpty()
    {
        ArrayList<String> testUserFiltersList = testData.userWith3Filters.getFiltersList();

        assertNotNull(testUserFiltersList);
        assertEquals(3, testUserFiltersList.size());

        String[] filter1 = testUserFiltersList.get(0).split(";");
        assertEquals(filter1[0], Filter.ORDER_PRICE);
        assertEquals(filter1[1], Filter.GREATER);
        assertEquals(filter1[2], "1.8");

        String[] filter2 = testUserFiltersList.get(1).split(";");
        assertEquals(filter2[0], Filter.ORDER_NAME);
        assertEquals(filter2[1], Filter.EQUAL);
        assertEquals(filter2[2], "2.5676");

        String[] filter3 = testUserFiltersList.get(2).split(";");
        assertEquals(filter3[0], Filter.ORDER_DELIVERY_DATE);
        assertEquals(filter3[1], Filter.EQUAL);
        assertEquals(filter3[2], "01-02-2024");
    }

    // Punkt 2 - obsługa wyjątków
    @Override
    public void handleTestExecutionException(ExtensionContext arg0, Throwable arg1) throws Throwable {
        // Wyrzucane przez addFilter
        if(arg1 instanceof IllegalArgumentException && arg0.getTestMethod().get().getName().equals("testAddFilter"))
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