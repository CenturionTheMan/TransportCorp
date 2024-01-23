package com.tasnporstcorp.test.TestyFitNesse;

import com.tasnporstcorp.app.Application;
import com.tasnporstcorp.app.orders.Order;
import fit.ColumnFixture;
import jdk.jshell.Snippet;

public class TestUpdateOrderStatus extends ColumnFixture {

    public String dane[];

    Application application = new Application();

    public boolean testUpdateOrderStatus()
    {
        int id = Integer.parseInt(dane[0]);
        Order.OrderStatus status;
        try
        {
            status = Order.OrderStatus.valueOf(dane[1]);
        }
        catch (Exception ex)
        {
            return false;
        }
        return application.updateOrderStatus(id, status);
    }
}
