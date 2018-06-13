package wrapper;

import model.JSONData;
import writers.JSONGenerate;

public class JSONGenerateWapper {

    public JSONGenerate jsonGenerate;
    public JSONData jsonData;
    public String output;
    public Long number;

    public JSONGenerateWapper() {
        super();
    }

    public boolean writeToFile()
    {
        jsonGenerate = new JSONGenerate(output,"data");
        return jsonGenerate.generate(jsonData);
    }
}
