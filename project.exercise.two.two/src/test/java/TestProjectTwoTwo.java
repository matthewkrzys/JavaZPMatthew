import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;


public class TestProjectTwoTwo {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void CommandData(){
        CommandData c = new CommandData();
        c.setCustomerID("12");
        String date=LocalTime.now().toString();
        c.setDateRange(date);
        c.setEventsCount("50");
        c.setOutDir("/output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        Assert.assertTrue(c.getOutDir().equals("/output"));
        Assert.assertTrue(!c.getEventsCount().equals(""));
        Assert.assertTrue(c.getItemsFile().equals("items.csv")&&c.getItemsQuantity().equals("4:5")&&c.getItemsCount().equals("3:12"));
        Assert.assertTrue(c.getCustomerID().equals("12")&&c.getDateRange().equals(date));
    }
    @Test
    public void Element(){
        Element e= new Element();
        e.name="Name";
        e.price=5.0;
        e.quantity=6;
        Assert.assertTrue(e.price==5.0);
    }
    @Test
    public void ElementFile(){
        ElementFile e=new ElementFile();
        e.name="Name";
        e.price=5.0;
        Assert.assertTrue(e.name.equals("Name"));
    }
    @Test
    public void JSONData(){
        JSONData j =new JSONData();
        j.customer_id=12;
        j.timestamp=LocalTime.now().toString();
        j.sum=20.3;
        Assert.assertTrue(j.customer_id==12);
    }
    @Test
    public void ElementFileTest(){
        ElementFile elementFile=new ElementFile();
        elementFile.price=2.0;
        elementFile.name="Beer";
        Assert.assertTrue(elementFile.name.equals("Beer")&&elementFile.price==2.0);
    }
//    @Test
//    public void mainTest(){
//        String ars[]= new String[] {"-customerIds", "1:25", "-dateRange", "2018-03-08T00:00:00.000-0100:2018-03-12T23:59:59.999-0100",
//                "-itemsFile", "items.csv", "-itemsCount", "5:15", "-itemsQuantity", "1:30", "-eventsCount", "1000", "-outDir", "./output"};
//        MainClass mainClass=new MainClass();
//        mainClass.main(ars);
//    }
}
