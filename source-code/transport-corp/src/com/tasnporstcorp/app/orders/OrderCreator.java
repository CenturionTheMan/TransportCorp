package com.tasnporstcorp.app.orders;

import com.tasnporstcorp.app.*;
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
	public void createNewOrder(String[] formData, User user) {
		var commodity = new Commodity(formData[0], Double.parseDouble(formData[1]), Double.parseDouble(formData[2]), Double.parseDouble(formData[3]));
        var order = new Order(commodity, user, formData[4], formData[5], formData[6]);
        boolean doesOrderExists = dataBaseApi.checkIfOrderExists(order);
        if(doesOrderExists)
        {
            String userInteraction = guiHandler.showDialogBox("Zamówienie o takich parametrach już istnieje. Czy chcesz kontynuować składanie zamówienia?");
            if(userInteraction.contains("NO"))
            {
                return;
            }
        }

        int nextOrderId = dataBaseApi.getNextOrderId();
        order.setId(nextOrderId);
        
        boolean isSuccess = dataBaseApi.postNewOrder(order);
        if(isSuccess)
        {
            guiHandler.showMessageBox("Dodano nowe zamówienie");
        }
        else
        {
            guiHandler.showMessageBox("Nie udało się dodać zamówienia");
        }
	}

}