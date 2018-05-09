import model.JSONData;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class TestJSONGenerator {


    @Test
    public void testWriteToFile(){
        JSONGenerate jsonGenerate=new JSONGenerate();
        JSONData jsonData=new JSONData(
                LocalDate.now().toString(),
                1,
                new ArrayList<>(),
                2.0
        );
        JSONGenerateWapper jsonGenerateWapper=new JSONGenerateWapper();
        jsonGenerateWapper.jsonGenerate=mock(JSONGenerate.class);
        jsonGenerateWapper.jsonData=mock(JSONData.class);
        jsonGenerateWapper.number=1L;
        Mockito.when(jsonGenerateWapper.writeToFile()).thenReturn(true);
        Assert.assertTrue(jsonGenerateWapper.writeToFile());
    }
}
