import model.CommandData;
import model.ElementFile;
import model.JSONData;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestParseToJSON {
    @Mock
    ParseToJSON parseToJSON;

    @Mock
    JSONGenerate jsonGenerate;

    @Test
    public void randomTest() {
        ParseToJSON parseToJSON = new ParseToJSON();
        int tmp = parseToJSON.randomGenerate(7, 2);
        Assert.assertTrue(tmp != 0);
    }
    @Test
    public void parseCommandDateTest(){
        parseToJSON=new ParseToJSON();
        CommandData c = new CommandData();
        c.setCustomerID("1:12");
        String date= "2018-03-08T00:00:00.000-0100:2018-03-08T00:00:00.000-0100";
        c.setDateRange(date);
        c.setEventsCount("1");
        c.setOutDir("./output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
//        jsonGenerate=new JSONGenerate();
//        Mockito.when(parseToJSON.GenerateJSON(jsonGenerate,new JSONData(),"./",2)).thenReturn(Boolean.TRUE);
        parseToJSON.parseCommandData(c);
        Assert.assertTrue(parseToJSON.jsonData!=null);
    }
    @Test
    public void generateDateTest(){
        ParseToJSON parseToJSON=new ParseToJSON();
        String tmp=parseToJSON.generatedata("2018-03-08T00:00:00.000-0100","2018-04-08T00:00:00.000-0100");
        Assert.assertTrue(!tmp.isEmpty());
    }
    @Test
    public void ItemFileTest(){
        ParseToJSON p=new ParseToJSON();
        List e=p.getItemFile(0,1,20,"items.csv");
        Assert.assertTrue(e.size()==0);
    }
    @Test
    public void getElementFromFileTest(){
        ParseToJSON p=new ParseToJSON();
        List e=p.getElementFromFile("items.csv");
        Assert.assertTrue(e.size()>0);
    }
}
