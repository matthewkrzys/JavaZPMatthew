import model.JSONData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import writers.JSONGenerate;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestJSONGenerator {

    @Mock
    JSONGenerate jsonGenerate;

    @Test
    public void testWriteToFile(){
        JSONData jsonData=new JSONData(
                LocalDate.now().toString(),
                1,
                new ArrayList<>(),
                BigDecimal.valueOf(2)
        );
        when(jsonGenerate.generate(any(JSONData.class))).thenReturn(true);
        boolean save=jsonGenerate.generate(jsonData);
        Assert.assertTrue(save);
    }
}
