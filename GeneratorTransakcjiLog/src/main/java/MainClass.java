import model.CommandData;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainClass {
    final static Logger logger = LoggerFactory.getLogger(MainClass.class);
    final static String TAG=MainClass.class.getName();
    public static void main(String[] args) {
        logger.info(TAG+" Args "+args);
        Manager manager=new Manager();
        CommandData commandData;
        ParseToJSON parseToJSON=new ParseToJSON();
        try {
            logger.info(TAG+" Start Get Data from Args");
            commandData=manager.getData(args);
            logger.info(TAG+" Get Data "+commandData.toString());
            logger.info(TAG+" Start Parse To JSON ");
            parseToJSON.parseCommandData(commandData);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(TAG+" "+e);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error(TAG+" "+e);
        }
    }
}