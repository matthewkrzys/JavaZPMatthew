package writers;

import model.JSONData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import writers.Generatable;

import java.io.File;
import java.io.IOException;

public class JSONGenerate implements Generatable {

    private String outputDir;
    private String nameJson;
    private static long numberFile = 1;

    public JSONGenerate(String output, String nameJson) {
        this.outputDir = output;
        this.nameJson = nameJson;
    }

    public boolean generate(JSONData jsonParse) {

        ObjectMapper mapper = new ObjectMapper();

        JSONData jsonData = jsonParse;
        numberFile++;

        try {
            String path = outputDir + "/" + nameJson + numberFile + ".json";
            if (new File(outputDir).exists()) {
            } else {
                new File(outputDir).mkdirs();
            }
            mapper.writeValue(new File(path), jsonData);
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
