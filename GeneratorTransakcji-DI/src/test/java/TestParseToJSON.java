import components.ParseToJSON;
import logic.RandomData;
import logic.WriteFromCSV;
import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import writers.Generatable;
import writers.JSONGenerate;
import writers.XMLGenerate;
import writers.YAMLGenerate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestParseToJSON {
    @Mock
    ParseToJSON parseToJSON;

    @Mock
    WriteFromCSV writeFromCSV;

    @Mock
    Generatable generatable;

    @Mock
    JSONGenerate jsonGenerate;

    @Mock
    XMLGenerate xmlGenerate;

    @Mock
    YAMLGenerate yamlGenerate;

    @Mock
    RandomData randomData;
    @Before
    public void before(){
        when(randomData.randomGenerate(any(Integer.class),any(Integer.class))).thenReturn(1);
        when(randomData.generatedata(any(String.class),any(String.class))).thenReturn("ala");
        List<Element> elementList=Arrays.asList(new Element("Maslo",2,3.0),new Element("Tunczyk",3,4.0));
        when(writeFromCSV.getItemFile(any(Integer.class),any(Integer.class),any(Integer.class),any(String.class)))
                .thenReturn(elementList);
    }

    @Test
    public void randomTest() {
        RandomData generate=new RandomData();
        int tmp = generate.randomGenerate(7, 2);
        Assert.assertTrue(tmp != 0);
    }
    @Test
    public void parseCommandDateTest(){
        parseToJSON=new ParseToJSON(new JSONGenerate("./output","jsonData"));
        CommandData c = new CommandData();
        c.setCustomerID("1:12");
        String date= "2018-03-08T00:00:00.000-0100:2018-03-08T00:00:00.000-0100";
        c.setDateRange(date);
        c.setEventsCount("1");
        c.setOutDir("./output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        when(generatable.generate(any(JSONData.class))).thenReturn(true);
        parseToJSON.parseCommandData(c);
        Assert.assertTrue(parseToJSON.jsonData!=null);
    }
    @Test
    public void XMLparseCommandDateTest(){
        parseToJSON=new ParseToJSON(new JSONGenerate("./output","jsonData"));
        CommandData c = new CommandData();
        c.setCustomerID("1:12");
        String date= "2018-03-08T00:00:00.000-0100:2018-03-08T00:00:00.000-0100";
        c.setDateRange(date);
        c.setEventsCount("1");
        c.setOutDir("./output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        c.setFormat("XML");
        when(generatable.generate(any(JSONData.class))).thenReturn(true);
        parseToJSON.parseCommandData(c);
        Assert.assertTrue(parseToJSON.jsonData!=null);
    }
    @Test
    public void YAMLparseCommandDateTest(){
        parseToJSON=new ParseToJSON(new JSONGenerate("./output","jsonData"));
        CommandData c = new CommandData();
        c.setCustomerID("1:12");
        String date= "2018-03-08T00:00:00.000-0100:2018-03-08T00:00:00.000-0100";
        c.setDateRange(date);
        c.setEventsCount("1");
        c.setOutDir("./output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        c.setFormat("YAML");
        when(generatable.generate(any(JSONData.class))).thenReturn(true);
        parseToJSON.parseCommandData(c);
        Assert.assertTrue(parseToJSON.jsonData!=null);
    }
    @Test
    public void JSONGenerateTest(){
        when(jsonGenerate.generate(any(JSONData.class))).thenReturn(true);
        Assert.assertTrue(jsonGenerate.generate(new JSONData("123",12,new ArrayList<>(), BigDecimal.valueOf(3))));
    }

    @Test
    public void XMLGenerateTest(){
        when(xmlGenerate.generate(any(JSONData.class))).thenReturn(true);
        Assert.assertTrue(xmlGenerate.generate(new JSONData("123",12,new ArrayList<>(), BigDecimal.valueOf(3))));
    }
    @Test
    public void YAMLGenerateTest(){
        when(yamlGenerate.generate(any(JSONData.class))).thenReturn(true);
        Assert.assertTrue(yamlGenerate.generate(new JSONData("123",12,new ArrayList<>(), BigDecimal.valueOf(3))));
    }
        @Test
    public void generateDateTest(){
        RandomData generate=new RandomData();
        String tmp=generate.generatedata("2018-03-08T00:00:00.000-0100","2018-04-08T00:00:00.000-0100");
        Assert.assertTrue(!tmp.isEmpty());
    }
    @Test
    public void ItemFileTest(){
        List<Element> elementList=Arrays.asList(new Element("Maslo",2,3.0),new Element("Tunczyk",3,4.0));
        when(writeFromCSV.getItemFile(any(Integer.class),any(Integer.class),any(Integer.class),any(String.class)))
                .thenReturn(elementList);
        List<Element> e=writeFromCSV.getItemFile(0,1,20,"items.csv");
        Assert.assertTrue(e.get(0).name.equals("Maslo"));
    }
    @Test
    public void getElementFromFileTest(){
        List<ElementFile> elementList= Arrays.asList(new ElementFile("Cos",2.0));
        when(writeFromCSV.getElementFromFile(any(String.class)))
                .thenReturn(elementList);
        List<ElementFile> e=writeFromCSV.getElementFromFile("items.csv");
        Assert.assertTrue(e.get(0).name.equals("Cos"));
    }
}
