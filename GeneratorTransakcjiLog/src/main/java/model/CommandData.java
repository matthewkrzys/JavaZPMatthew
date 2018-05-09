package model;

public class CommandData {
    private String CustomerID;
    private String DateRange;
    private String ItemsFile;
    private String ItemsCount;
    private String ItemsQuantity;
    private String EventsCount;
    private String OutDir;

    public CommandData() {
        CustomerID="1:20";
        ItemsCount = "1:5";
        ItemsQuantity = "1:5";
        EventsCount = "100";
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

    public String getItemsFile() {
        return ItemsFile;
    }

    public void setItemsFile(String itemsFile) {
        ItemsFile = itemsFile;
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

    public String getOutDir() {
        return OutDir;
    }

    public void setOutDir(String outDir) {
        OutDir = outDir;
    }

    @Override
    public String toString() {
        return "CommandData{" +
                "CustomerID='" + CustomerID + '\'' +
                ", DateRange='" + DateRange + '\'' +
                ", ItemsFile='" + ItemsFile + '\'' +
                ", ItemsCount='" + ItemsCount + '\'' +
                ", ItemsQuantity='" + ItemsQuantity + '\'' +
                ", EventsCount='" + EventsCount + '\'' +
                ", OutDir='" + OutDir + '\'' +
                '}';
    }
}
