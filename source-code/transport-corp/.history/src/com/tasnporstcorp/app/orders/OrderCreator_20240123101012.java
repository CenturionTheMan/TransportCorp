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
	 * Zamieszcza nowe zamówienie w bazie danych. 
	 * @param formData dane z formularza wypełnionego przez użytkownika przy pomocy GUI
     * @return Id nowego zamówienia bądź -1 w przypadku niepowodzenia.
     * @throws UnsupportedOperationException przy złożenia zamówienia, którego adres nadania i odbioru są identyczne
	 */
	public int createNewOrder(ArrayList<String> formData, User user) throws UnsupportedOperationException {
        if(user == null)
        {
            throw new UnsupportedOperationException("User is null");
        }

		var commodity = new Commodity(
            formData.get(0), 
            Double.parseDouble(formData.get(1)), 
            Double.parseDouble(formData.get(2)), 
            Double.parseDouble(formData.get(3))
        );
        
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
            return -1;
            //}
        }

        int nextOrderId = dataBaseApi.getNextOrderId();
        order.setId(nextOrderId);
        
        boolean isSuccess = dataBaseApi.postNewOrder(order);
        if(isSuccess)
        {
            //guiHandler.showMessageBox("Dodano nowe zamówienie");
            return nextOrderId;
        }
        else
        {
            //guiHandler.showMessageBox("Nie udało się dodać zamówienia");
            return -1;
        }
	}

}