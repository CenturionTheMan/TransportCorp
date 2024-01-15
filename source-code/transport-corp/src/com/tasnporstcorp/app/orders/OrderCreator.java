package com.tasnporstcorp.app.orders;
import java.util.*;
import com.tasnporstcorp.app.*;
import com.tasnporstcorp.app.database.DataBaseAPI;
import com.tasnporstcorp.app.users.User;

public class OrderCreator {

	private GUIHandler guiHandler;
	private DataBaseAPI dataBaseApi;

	/**
	 * 
	 * @param guiHandler
	 * @param databaseApi
	 */
	public OrderCreator(GUIHandler guiHandler, DataBaseAPI databaseApi) {
		this.guiHandler = guiHandler;
		this.dataBaseApi = databaseApi;
	}

    

	/**
	 * 
	 * @param formData
	 */
	public boolean createNewOrder(ArrayList<String> formData, User user) {
		var commodity = new Commodity(formData.get(0), Double.parseDouble(formData.get(1)), Double.parseDouble(formData.get(2)), Double.parseDouble(formData.get(3)));
        
        if(formData.get(5).equals(formData.get(6)))
        {
            throw new UnsupportedOperationException("Sender and receiver address cannot be the same.");    
        }

        var order = new Order(commodity, user, formData.get(4), formData.get(5), formData.get(6));
        boolean doesOrderExists = dataBaseApi.checkIfOrderExists(order);
        if(doesOrderExists)
        {
            //String userInteraction = guiHandler.showDialogBox("Zamówienie o takich parametrach już istnieje. Czy chcesz kontynuować składanie zamówienia?");
            //if(userInteraction.contains("NO"))
            //{
            return false;
            //}
        }

        int nextOrderId = dataBaseApi.getNextOrderId();
        order.setId(nextOrderId);
        
        boolean isSuccess = dataBaseApi.postNewOrder(order);
        if(isSuccess)
        {
            //guiHandler.showMessageBox("Dodano nowe zamówienie");
            return true;
        }
        else
        {
            //guiHandler.showMessageBox("Nie udało się dodać zamówienia");
            return false;
        }
	}

}