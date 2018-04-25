import model.CommandData;
import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ManagerTest {
    @Test
    public void getDataTest(){
        Manager manager=new Manager();
        String ars[]= new String[] {"-customerIds", "1:25", "-dateRange", "2018-03-08T00:00:00.000-0100:2018-03-12T23:59:59.999-0100",
                "-itemsFile", "items.csv", "-itemsCount", "5:15", "-itemsQuantity", "1:30", "-eventsCount", "1000", "-outDir", "./output"};

        CommandData commandData= null;
        try {
            commandData = manager.getData(ars);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(commandData.getItemsFile().equals("items.csv"));
    }

    @Test
    public void getDataWithErrorTest(){
        Manager manager=new Manager();
        String ars[]= new String[] {"-customerIds", "1:25", "-dateRange", "2018-03-08T00:00:00.000-0100:2018-03-12T23:59:59.999-0100",
                "", "", "-itemsCount", "5:15", "-itemsQuantity", "1:30", "-eventsCount", "1000", "-outDir", "./output"};

        CommandData commandData= null;
        try {
            commandData = manager.getData(ars);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(commandData.getItemsFile()==null);
    }

    @Test
    public void getDataUnfortunatelyTest(){
        Manager manager=new Manager();
        String ars[]= new String[] {"-customerId", "1:25", "-dateRange", "2018-03-08T00:00:00.000-0100:2018-03-12T23:59:59.999-0100",
                "", "", "-itemsCount", "5:15", "-itemsQuantity", "1:30", "-eventsCount", "1000", "-outDir", "./output"};

        CommandData commandData= null;
        try {
            commandData = manager.getData(ars);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(commandData.getCustomerID().equals("1:20"));
    }
}
