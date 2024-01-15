package com.tasnporstcorp.tests;

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

@Tag("LoggedInUser") 
public class LoggedInUserTest implements TestExecutionExceptionHandler{     // test implementuje niestandardową obsługę wyjątków

    static TestData testData;

    // Punkt 2 - wykorzystanie metody wykonującej się przez wszystkimi testami
    @BeforeAll 
    public static void init()
    {
        testData = new TestData();
    }

    // Punkt 2 - metoda generująca dane nt. filtrów ustalonych przez użytkownika w GUI
    public static Stream<Arguments> getTestFilters()
    {
        ArrayList<Arguments> filters = new ArrayList<Arguments>();
        for (String filterAttribute : testData.testFilterAttributes) 
            for(String filterCondition : testData.filterConditions)
                filters.add(Arguments.of(filterAttribute, filterCondition));
        return filters.stream();
    }

    // Punkt 2 - wykorzystane testy wielokrotne, wykorzystujące dane generowane za pomocą metody "getTestFilters()"
    @ParameterizedTest()
    @MethodSource("getTestFilters")
    @ExtendWith(LoggedInUserTest.class)
    public void testAddFilter(String attribute, String condition)
    {
        int sizeBeforeAddition = testData.userWith3Filters.getFiltersList().size();
        try {
            testData.userWith3Filters.addFilter(attribute, condition, "1");
        } catch (Exception e) {
            
        }

        assertEquals(sizeBeforeAddition+1, testData.userWith3Filters.getFiltersList().size(), "Lista filtrów powinna się powiększyć");
    }

    // Punkt 2 - wykorzystane testy wielokrotne, wykorzystujące dane generowane z wartości oddzielanych przecinkami
    @ParameterizedTest()
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
        testData.userWith3Filters.removeFilter(indexOfFilter);

        assertEquals(sizeBeforeDeletion-1, testData.userWith3Filters.getFiltersList().size());
    }

    // Punkt 2 - niestandardowa obsługa wyjątków
    @Override
    public void handleTestExecutionException(ExtensionContext arg0, Throwable arg1) throws Throwable {
        System.out.print("EXCEPTION in test of" + arg0.getTestMethod() + "(" + arg0.getDisplayName() + ")" + ": ");
        if(arg1 instanceof IllegalArgumentException)
        {
            System.out.println(arg1.getMessage());
            throw arg1;
        }
        else
        {
            System.out.print("nieznany");
        }
        throw arg1;
    }

} 