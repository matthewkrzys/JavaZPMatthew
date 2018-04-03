import model.JSONData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONGenerate {
    final static Logger logger = LoggerFactory.getLogger(JSONGenerate.class);
    public boolean generate(JSONData jsonParse,String output,long numberFile) {

        ObjectMapper mapper = new ObjectMapper();

        JSONData jsonData=jsonParse;

        try {
            String path=output+"/jsonData"+numberFile+".json";
            if(new File(output).exists()){
                logger.info("File "+output+" is exists");
            }
            else
            {
                logger.info("File "+output+" is not exists");
                logger.info("Create file "+output);
                new File(output).mkdirs();
            }
            mapper.writeValue(new File(path), jsonData);
            logger.info("Write File: "+"jsonData"+numberFile);
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
