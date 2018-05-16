package logic;

import model.CommandData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WriteArgsFromFile {
    CommandData commandData;

    public WriteArgsFromFile() {
        commandData=new CommandData();
    }

    public String[] getArgs(String path){
        File f=new File(path);
        String array="";
        try {
            Scanner sc=new Scanner(f);
            while (sc.hasNext()){
                String tmp=sc.nextLine();
                addParam(tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array.split(";");
    }

    private void addParam(String tmp) {
        if(tmp.contains("itemsFile"))
            commandData.setItemsFile(tmp.split("=")[1]);
        if(tmp.contains("customerIds"))
            commandData.setCustomerID(tmp.split("=")[1]);
        if(tmp.contains("dateRange"))
            commandData.setDateRange(tmp.split("=")[1].replace("\"",""));
        if(tmp.contains("itemsCount"))
            commandData.setItemsCount(tmp.split("=")[1]);
        if(tmp.contains("itemsQuantity"))
            commandData.setItemsQuantity(tmp.split("=")[1]);
        if(tmp.contains("outDir"))
            commandData.setOutDir(tmp.split("=")[1]);
        if(tmp.contains("eventsCount"))
            commandData.setEventsCount(tmp.split("=")[1]);
        if(tmp.contains("format"))
            commandData.setFormat(tmp.split("=")[1]);

    }
    public CommandData getCommandData(){
        return commandData;
    }
}
