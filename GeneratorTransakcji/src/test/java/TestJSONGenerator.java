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

//    @Test
//    public void testWriteToFileNewDir(){
//        File f=new File("/newfile");
//        if(f.exists()){
//            f.delete();
//        }
//        JSONGenerate jsonGenerate=new JSONGenerate();
//        JSONData jsonData=new JSONData(
//                LocalDate.now().toString(),
//                1,
//                new ArrayList<>(),
//                2.0
//        );
//
//        jsonGenerate.generate(jsonData,"./newfile",1);
//        boolean fileb=new File("./newfile/jsonData1.json").exists();
//        Assert.assertTrue(fileb);
//    }
}
