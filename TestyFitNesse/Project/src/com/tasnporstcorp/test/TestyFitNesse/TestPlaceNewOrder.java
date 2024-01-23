package com.tasnporstcorp.test.TestyFitNesse;
import java.util.ArrayList;

import com.tasnporstcorp.app.Application;
import com.tasnporstcorp.app.GUIHandler;
import fit.ColumnFixture;

public class TestPlaceNewOrder extends ColumnFixture {

    public String dane[];
    Application application = new Application();


    public boolean testPlaceNewOrder()
    {
        String name = dane[0];
        String lengthCm = dane[1];
        String widthCm = dane[2];
        String depthCm = dane[3];
        String deliveryDate = dane[4];
        String senderAddress = dane[5];
        String receiverAddress = dane[6];

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

        int placedOderId = -1;
        boolean isOrderCreated = false;
        try {
            placedOderId = application.placeNewOrder();
            isOrderCreated = true;
        }
        catch (Exception ex)
        {

        }

        boolean isOrderIdCorrect = placedOderId != -1;
        com.tasnporstcorp.app.orders.Order order = application.getDatabase().getOrder(placedOderId);
        boolean isOrderInDatabase = order != null;

        //assertEquals(order.getReceiverAddress(), receiverAddress);
        //assertEquals(order.getSenderAddress(), senderAddress);
        //Commodity commodity = order.getTransportedCommodity();
        //assertEquals(commodity.depthCm, Double.parseDouble(depthCm), 0);
        //assertEquals(commodity.widthCm, Double.parseDouble(widthCm), 0);
        //assertEquals(commodity.lengthCm, Double.parseDouble(lengthCm), 0);
        return isOrderIdCorrect && isOrderInDatabase && isOrderCreated;
    }

}
