import components.ParseToJSON;
import logic.WriteFromCSV;
import model.CommandData;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import writers.JSONGenerate;

import java.util.List;

public class TestParseToJSON {
    @Mock
    ParseToJSON parseToJSON;

    @Mock
    JSONGenerate jsonGenerate;

    @Test
    public void randomTest() {
        Generate generate=new Generate();
        int tmp = generate.randomGenerate(7, 2);
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
//        jsonGenerate=new writers.JSONGenerate();
//        Mockito.when(parseToJSON.GenerateJSON(jsonGenerate,new JSONData(),"./",2)).thenReturn(Boolean.TRUE);
        parseToJSON.parseCommandData(c);
        Assert.assertTrue(parseToJSON.jsonData!=null);
    }
    @Test
    public void generateDateTest(){
        Generate generate=new Generate();
        String tmp=generate.generatedata("2018-03-08T00:00:00.000-0100","2018-04-08T00:00:00.000-0100");
        Assert.assertTrue(!tmp.isEmpty());
    }
    @Test
    public void ItemFileTest(){
        WriteFromCSV writeFromCSV=new WriteFromCSV();
        List e=writeFromCSV.getItemFile(0,1,20,"items.csv");
        Assert.assertTrue(e.size()==0);
    }
    @Test
    public void getElementFromFileTest(){
        WriteFromCSV writeFromCSV=new WriteFromCSV();
        List e=writeFromCSV.getElementFromFile("items.csv");
        Assert.assertTrue(e.size()>0);
    }
}
