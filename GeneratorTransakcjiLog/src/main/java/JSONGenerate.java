import model.JSONData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class JSONGenerate {
    final static Logger logger = LoggerFactory.getLogger(JSONGenerate.class);
    final static String TAG= JSONGenerate.class.getName();
    public boolean generate(JSONData jsonParse,String output,long numberFile) {

        ObjectMapper mapper = new ObjectMapper();

        JSONData jsonData=jsonParse;

        try {
            String path=output+"/jasonData"+numberFile+".json";
            if(new File(output).exists()){
            }
            else
            {
                new File(output).mkdirs();
            }
            mapper.writeValue(new File(path), jsonData);
//            System.out.println("Done");
            return true;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
return false;
    }

}
