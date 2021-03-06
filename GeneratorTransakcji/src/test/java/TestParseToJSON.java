import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestParseToJSON {
    @Mock
    ParseToJSON parseToJSON;

    @Mock
    JSONGenerate jsonGenerate;

    @Mock
    WriteFromCSV writeFromCSV;

    @Test
    public void randomTest() {
        Generate generate=new Generate();
        int tmp = generate.randomGenerate(7, 2);
        Assert.assertTrue(tmp != 0);
    }
    @Test
    public void parseCommandDateTest(){
//        parseToJSON=new ParseToJSON();
        CommandData c = new CommandData();
        c.setCustomerID("1:12");
        String date= "2018-03-08T00:00:00.000-0100:2018-03-08T00:00:00.000-0100";
        c.setDateRange(date);
        c.setEventsCount("1");
        c.setOutDir("./output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        when(parseToJSON.GenerateJSON(any(JSONGenerate.class),any(JSONData.class),any(String.class),any(Integer.class)))
                .thenReturn(false);
        parseToJSON.parseCommandData(c);
//        Assert.assertTrue(parseToJSON.jsonData==null);
    }
    @Test
    public void generateDateTest(){
        Generate generate=new Generate();
        String tmp=generate.generatedata("2018-03-08T00:00:00.000-0100","2018-04-08T00:00:00.000-0100");
        Assert.assertTrue(!tmp.isEmpty());
    }
    @Test
    public void ItemFileTest(){
        List<Element> elementList=new ArrayList<>();
        when(writeFromCSV.getItemFile(any(Integer.class),any(Integer.class),any(Integer.class),any(String.class)))
                .thenReturn(elementList);
        List e=writeFromCSV.getItemFile(0,1,20,"items.csv");
        Assert.assertTrue(e.size()==0);
    }
    @Test
    public void getElementFromFileTest(){
        List<ElementFile> elementList= Arrays.asList(new ElementFile("Cos",2.0));
        when(writeFromCSV.getElementFromFile(any(String.class)))
                .thenReturn(elementList);
        List e=writeFromCSV.getElementFromFile("items.csv");
        Assert.assertTrue(e.size()>0);
    }
}
