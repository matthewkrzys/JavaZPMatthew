import model.JSONData;
import org.junit.Assert;
import org.junit.Test;
import writers.JSONGenerate;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

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
        jsonGenerate.generate(jsonData,"./",1);
        boolean fileb=new File("./jsonData1.json").exists();
        Assert.assertTrue(fileb);
    }

    @Test
    public void testWriteToFileNewDir(){
        File f=new File("/newfile");
        if(f.exists()){
            f.delete();
        }
        JSONGenerate jsonGenerate=new JSONGenerate();
        JSONData jsonData=new JSONData(
                LocalDate.now().toString(),
                1,
                new ArrayList<>(),
                2.0
        );

        jsonGenerate.generate(jsonData,"./newfile",1);
        boolean fileb=new File("./newfile/jsonData1.json").exists();
        Assert.assertTrue(fileb);
    }
}
