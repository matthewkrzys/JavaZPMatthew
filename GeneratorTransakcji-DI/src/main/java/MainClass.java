import components.ParseToJSON;
import model.CommandData;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        Manager manager=new Manager();
        CommandData commandData;
        ParseToJSON parseToJSON=new ParseToJSON();
        try {
            commandData=manager.getData(args);
            parseToJSON.parseCommandData(commandData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
