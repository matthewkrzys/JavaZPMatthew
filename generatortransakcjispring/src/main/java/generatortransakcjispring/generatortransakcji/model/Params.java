package generatortransakcjispring.generatortransakcji.model;



public class Params {
    private final String DEFAULT_VALUE_CustomerID="1:20";
    private final String DEFAULT_VALUE_ItemsCount = "1:5";
    private final String DEFAULT_VALUE_ItemsQuantity = "1:5";
    private final String DEFAULT_VALUE_EventsCount = "100";

    private String CustomerID;
    private String DateRange;
    private String ItemsCount;
    private String ItemsQuantity;
    private String EventsCount;

    public Params() {
        CustomerID=DEFAULT_VALUE_CustomerID;
        ItemsCount = DEFAULT_VALUE_ItemsCount;
        ItemsQuantity = DEFAULT_VALUE_ItemsQuantity;
        EventsCount = DEFAULT_VALUE_EventsCount;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getDateRange() {
        return DateRange;
    }

    public void setDateRange(String dateRange) {
        DateRange = dateRange;
    }

    public String getItemsCount() {
        return ItemsCount;
    }

    public void setItemsCount(String itemsCount) {
        ItemsCount = itemsCount;
    }

    public String getItemsQuantity() {
        return ItemsQuantity;
    }

    public void setItemsQuantity(String itemsQuantity) {
        ItemsQuantity = itemsQuantity;
    }

    public String getEventsCount() {
        return EventsCount;
    }

    public void setEventsCount(String eventsCount) {
        EventsCount = eventsCount;
    }
}
