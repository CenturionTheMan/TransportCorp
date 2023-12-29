public class Application {
    private OrderCreator orderCreator;

    public void placeNewOrder()
    {
        var formData = getFormData(); 
        orderCreator.createNewOrder(formData, currentUser);
    }

    public String[] getFormData()
    {
        return null;
    }
}
