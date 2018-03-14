import model.JSONData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONGenerate {
    public void generate(JSONData jsonParse,String output) {

        ObjectMapper mapper = new ObjectMapper();

        JSONData jsonData=jsonParse;

        try {
            String path="jasonData.json";
//            if(!output.equals(""))
//                path=output+"/jsonData.jason";

            mapper.writeValue(new File(path), jsonData);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
