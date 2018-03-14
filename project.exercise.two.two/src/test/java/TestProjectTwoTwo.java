import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

public class TestProjectTwoTwo {
    @Test
    public void CommandData(){
        CommandData c = new CommandData();
        c.setCustomerID("12");
        c.setDateRange(LocalTime.now().toString());
        c.setEventsCount("50");
        c.setOutDir("/output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        Assert.assertTrue(c.getOutDir().equals("/output"));
        Assert.assertTrue(!c.getEventsCount().equals(""));
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
        Assert.assertTrue(j.id==1);
    }
//    @Test
//    public void getData(){
//        Manager m=new Manager();
//
//    }
    @Test
    public void ParseJSONParseCommandData(){
        CommandData c = new CommandData();
        c.setCustomerID("12");
        c.setDateRange(LocalTime.now().toString());
        c.setEventsCount("50");
        c.setOutDir("/output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        ParseToJSON p=new ParseToJSON();
        p.parseCommandData(c);
    }
    @Test
    public void ParseJSONRandomGenerate(){
        ParseToJSON p=new ParseToJSON();
        int r=0;
        r=p.randomGenerate(1,20);
        Assert.assertTrue(r!=0);
    }
    @Test
    public void ParseJSONgetItemFile(){
        ParseToJSON p=new ParseToJSON();
        List e=p.getItemFile(0,1,20,"items.csv");
        Assert.assertTrue(e.size()==0);
    }
    @Test
    public void ParseJSONgetElementFromFile(){
        ParseToJSON p=new ParseToJSON();
        List e=p.getElementFromFile("items.csv");
        Assert.assertTrue(e.size()>0);
    }
}
