import model.CommandData;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainClass {

    final static Logger logger = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] args) {
        logger.info("Start Application");
        Manager manager = new Manager();
        CommandData commandData;
        ParseToJSON parseToJSON = new ParseToJSON();
        try {
            logger.info("Start Read Data");
            commandData = manager.getData(args);
            logger.info("End Read Data");
            logger.info("Start Parse to JSON");
            parseToJSON.parseCommandData(commandData);
            logger.info("End Parse to JSON");
        } catch (IOException e) {
            logger.error("IOException "+ e.getMessage());
            e.printStackTrace();
        } catch (ParseException e) {
            logger.error("ParseException "+ e.getMessage());
            e.printStackTrace();
        }
        logger.info("End Application");
    }
}
