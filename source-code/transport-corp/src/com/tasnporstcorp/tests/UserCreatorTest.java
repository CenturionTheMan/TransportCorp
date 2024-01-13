package com.tasnporstcorp.tests;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



import com.tasnporstcorp.app.DataBaseAPI;
import com.tasnporstcorp.app.GUIHandler;
import com.tasnporstcorp.app.users.UserCreator;


@Tag("UserCreator")
public class UserCreatorTest {

    static UserCreator userCreator;
    static DataBaseAPI dataBaseAPI;
    static GUIHandler guiHandler;

    @BeforeAll
    public static void Init() {
        guiHandler = new GUIHandler();
        dataBaseAPI = new DataBaseAPI();

        userCreator = new UserCreator(guiHandler, dataBaseAPI);
    }
    
    
    public void Tmp()
    {
        var list = new ArrayList<String>();
        list.add("pomidor1");        
        list.add("pomidor2");
        list.add("pomidor3");

        userCreator.registerNewUser(list);
    } 
}
