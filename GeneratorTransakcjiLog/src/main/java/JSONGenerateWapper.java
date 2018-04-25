import model.JSONData;

public class JSONGenerateWapper {

    JSONGenerate jsonGenerate;
    JSONData jsonData;
    String output;
    Long number;

    public JSONGenerateWapper() {

    }

    public boolean writeToFile(){
        return jsonGenerate.generate(jsonData,output,number);
    }
}
