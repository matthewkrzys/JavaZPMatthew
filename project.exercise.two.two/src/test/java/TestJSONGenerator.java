import model.JSONData;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestJSONGenerator {

    @Test
    public void testWriteToFile(){
        JSONGenerate jsonGenerate=new JSONGenerate();
        JSONData jsonData=new JSONData();
        jsonData.sum=2.0;
        jsonData.timestamp= LocalDate.now().toString();
        jsonData.customer_id=1;
        jsonData.items=new ArrayList<>();
        jsonGenerate.generate(jsonData,"./",1);
        boolean fileb=new File("./jasonData1.json").exists();
        Assert.assertTrue(fileb);
    }

    @Test
    public void testWriteToFileNewDir(){
        File f=new File("/newfile");
        if(f.exists()){
            f.delete();
        }
        JSONGenerate jsonGenerate=new JSONGenerate();
        JSONData jsonData=new JSONData();
        jsonData.sum=2.0;
        jsonData.timestamp= LocalDate.now().toString();
        jsonData.customer_id=1;
        jsonData.items=new ArrayList<>();
        jsonGenerate.generate(jsonData,"./newfile",1);
        boolean fileb=new File("./newfile/jasonData1.json").exists();
        Assert.assertTrue(fileb);
    }
}
