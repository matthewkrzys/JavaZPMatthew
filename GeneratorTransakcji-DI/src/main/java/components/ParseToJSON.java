package components;

import logic.RandomData;
import logic.WriteFromCSV;
import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.omg.CORBA.INTERNAL;
import writers.Generatable;
import writers.JSONGenerate;
import writers.XMLGenerate;
import writers.YAMLGenerate;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ParseToJSON {
    private BigDecimal sumPrice =BigDecimal.valueOf(0);
    public JSONData jsonData;
    WriteFromCSV writeFromCSV;
    RandomData generate;
    Generatable generatable;

    public ParseToJSON(Generatable generatable){
        writeFromCSV=new WriteFromCSV();
        generate=new RandomData();
        this.generatable=generatable;
    }

    public void parseCommandData(CommandData commandData) {

        String[] tCustomerID = commandData.getCustomerID().split(":");
        String[] tDataRange = commandData.getDateRange().replace("\"","").split(":");
        String[] tItemCount = commandData.getItemsCount().split(":");
        int ItemCount;
        String[] tItemQuantity = commandData.getItemsQuantity().split(":");
        commandData.getEventsCount();
        int count = Integer.parseInt(commandData.getEventsCount());
        for (int i = 1; i <= count; i++) {
            sumPrice=BigDecimal.valueOf(0);
            ItemCount = generate.randomGenerate(Integer.parseInt(tItemCount[1]), Integer.parseInt(tItemCount[0]));
            jsonData=new JSONData(
                    generate.generatedata(tDataRange[0]+":"+tDataRange[1]+":"+tDataRange[2],tDataRange[3]+":"+tDataRange[4]+":"+tDataRange[5]),
                    generate.randomGenerate(Integer.parseInt(tCustomerID[1]), Integer.parseInt(tCustomerID[0])),
                    writeFromCSV.getItemFile(ItemCount, Integer.parseInt(tItemQuantity[1]), Integer.parseInt(tItemQuantity[0]), commandData.getItemsFile()),
                    sumPrice
            );
            generatable.generate(jsonData);
        }

    }

}
