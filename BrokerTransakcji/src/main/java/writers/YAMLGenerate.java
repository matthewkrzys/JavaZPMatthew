package writers;

import model.Element;
import model.JSONData;

import java.io.*;

public class YAMLGenerate implements Generatable {

    private String outputDir;
    private String nameJson;
    private static long numberFile = 1;

    public YAMLGenerate(String output, String nameJson) {
        this.outputDir = output;
        this.nameJson = nameJson;
    }

    @Override
    public boolean generate(JSONData jsonParse) {
        File file = new File(outputDir);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
                return false;
            }
        }
        String pathFile = outputDir.replace("./","") + "/" + nameJson + numberFile + ".yaml";
        numberFile++;
        StringBuilder sb=new StringBuilder();
        sb.append("---!data");
        sb.append("\nid: "+jsonParse.id);
        sb.append("\ntimestamp: "+jsonParse.timestamp);
        sb.append("\ncustomer_id "+jsonParse.customer_id);
        sb.append("\nitems: ");
        for (Element e: jsonParse.items
             ) {
            sb.append("\n\t-Element");
            sb.append("\n\t\tname: "+e.name);
            sb.append("\n\t\tquantity: "+e.quantity);
            sb.append("\n\t\tprice "+e.price);
        }
        sb.append("\nsum "+jsonParse.sum);

        FileWriter fileWriter;
        File f=new File(pathFile);
        try {
            fileWriter=new FileWriter(f);
            fileWriter.append(sb);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
