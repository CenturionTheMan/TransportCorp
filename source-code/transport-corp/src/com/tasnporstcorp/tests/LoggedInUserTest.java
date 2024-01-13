package com.tasnporstcorp.tests;

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
public class LoggedInUserTest implements TestExecutionExceptionHandler{

    static Dane dane;

    @BeforeAll //punt 2
    public static void init()
    {
        dane = new Dane();
    }

    //punt 2
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

    //punt 2
    @ParameterizedTest()
    @MethodSource("testAddFilterValue")
    public void testAddFilter(String attribute, String condition)
    {
        int prevSize = dane.loggedInUser.getFiltersList().size();
        dane.loggedInUser.addFilter(attribute, condition);
        assertEquals(prevSize + 1, dane.loggedInUser.getFiltersList().size());
    }

    //punt 2
    @ParameterizedTest()
    @ExtendWith(LoggedInUserTest.class)
    @CsvSource({"2", "1", "0"})
    public void testRemoveFilter(int indexOfFilter)
    {
        int prevSize = dane.loggedInUser.getFiltersList().size();
        dane.loggedInUser.removeFilter(indexOfFilter);
        assertEquals(prevSize - 1, dane.loggedInUser.getFiltersList().size());
    }

    //punt 2
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