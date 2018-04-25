import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.omg.CORBA.INTERNAL;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ParseToJSON {
    private double sumPrice = 0;
    public JSONData jsonData;
    WriteFromCSV writeFromCSV;
    Generate generate;
    public ParseToJSON(){
        writeFromCSV=new WriteFromCSV();
        generate=new Generate();
    }

    public void parseCommandData(CommandData commandData) {

        String[] tCustomerID = commandData.getCustomerID().split(":");
        String[] tDataRange = commandData.getDateRange().split(":");
        String[] tItemCount = commandData.getItemsCount().split(":");
        int ItemCount;
        String[] tItemQuantity = commandData.getItemsQuantity().split(":");
        commandData.getEventsCount();
        JSONGenerate jsonGenerate = new JSONGenerate();
        int count = Integer.parseInt(commandData.getEventsCount());
        for (int i = 1; i <= count; i++) {
            sumPrice=0;
            ItemCount = generate.randomGenerate(Integer.parseInt(tItemCount[1]), Integer.parseInt(tItemCount[0]));
            jsonData=new JSONData(
                    generate.generatedata(tDataRange[0]+":"+tDataRange[1]+":"+tDataRange[2],tDataRange[3]+":"+tDataRange[4]+":"+tDataRange[5]),
                    generate.randomGenerate(Integer.parseInt(tCustomerID[1]), Integer.parseInt(tCustomerID[0])),
                    writeFromCSV.getItemFile(ItemCount, Integer.parseInt(tItemQuantity[1]), Integer.parseInt(tItemQuantity[0]), commandData.getItemsFile()),
                    sumPrice
            );
            GenerateJSON(jsonGenerate,jsonData, commandData.getOutDir(), i);
        }

    }
    public boolean GenerateJSON(JSONGenerate jsonGenerate, JSONData jsonData, String outDir, int i){
        return jsonGenerate.generate(jsonData, outDir, i);
    }


}
