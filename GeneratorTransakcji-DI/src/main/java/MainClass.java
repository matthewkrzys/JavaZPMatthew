import components.ParseToJSON;
import components.ReadStreamInput;
import model.CommandData;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        ReadStreamInput manager=new ReadStreamInput();
        CommandData commandData;
        ParseToJSON parseToJSON=new ParseToJSON();
        try {
            commandData=manager.readStream(args);
            parseToJSON.parseCommandData(commandData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
