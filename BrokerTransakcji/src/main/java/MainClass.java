import components.ParseToJSON;
import components.ReadStreamInput;
import logic.MessagingService;
import logic.WriteArgsFromFile;
import model.CommandData;
import org.apache.commons.cli.ParseException;
import writers.JSONGenerate;
import writers.XMLGenerate;
import writers.YAMLGenerate;

import java.io.IOException;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        ReadStreamInput manager=new ReadStreamInput();
        MessagingService messagingService = new MessagingService();
        CommandData commandData;
        ParseToJSON parseToJSON = null;
            WriteArgsFromFile writeArgsFromFile=new WriteArgsFromFile();
        try {
            if(args[0].contains(".properties")){
                writeArgsFromFile.getArgs(args[0]);
                commandData=writeArgsFromFile.getCommandData();
            }
            else{
                commandData=manager.readStream(args);
            }
            if(commandData.getFormat().equals("xml")){
                parseToJSON=new ParseToJSON(new XMLGenerate(commandData.getOutDir(), "xmlData"));
                try {
                    messagingService.checkIfMessagingAndSend(commandData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(commandData.getFormat().equals("yaml")){
                parseToJSON=new ParseToJSON(new YAMLGenerate(commandData.getOutDir(), "yamlData"));
//                try {
//                    messagingService.checkIfMessagingAndSend(commandData);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
            if(commandData.getFormat().equals("json")){
                parseToJSON=new ParseToJSON(new JSONGenerate(commandData.getOutDir(), "jsonData"));
//                try {
//                    messagingService.checkIfMessagingAndSend(commandData);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println(commandData);
            parseToJSON.parseCommandData(commandData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
/*
//        JSONGenerate jsonGenerate = new JSONGenerate(commandData.getOutDir(), "jsonData");
//        XMLGenerate xmlGenerate=new XMLGenerate(commandData.getOutDir(), "jsonData");
        YAMLGenerate yamlGenerate= ;
 */
