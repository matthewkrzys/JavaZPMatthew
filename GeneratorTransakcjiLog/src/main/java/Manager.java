import model.CommandData;
import org.apache.commons.cli.*;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Manager {
    final static Logger logger = LoggerFactory.getLogger(Manager.class);
    public CommandData getData(String[] args) throws IOException, ParseException {
        Options options;
        logger.info("Create options ");
        options=createOptions();
        CommandLineParser parser = new BasicParser();
        CommandLine cmd = null;
        CommandData commandData=new CommandData();

        try{
            cmd = parser.parse(options, args);
        }
        catch (ParseException pe){
            System.out.println("Unfortunately, arguments are not right");
            logger.warn("Unfortunately, arguments are not right");
            return commandData;
        }
        logger.info("Start read parameters");
        if (cmd.hasOption("customerIds"))
            commandData.setCustomerID(cmd.getOptionValue("customerIds"));
        if (cmd.hasOption("dateRange"))
            commandData.setDateRange(cmd.getOptionValue("dateRange"));
        if (cmd.hasOption("itemsFile"))
            commandData.setItemsFile(cmd.getOptionValue("itemsFile"));
        else {
            System.out.println("You haven't passed itemsFile arg");
            return commandData;
        }
        if (cmd.hasOption("itemsCount"))
            commandData.setItemsCount(cmd.getOptionValue("itemsCount"));
        if (cmd.hasOption("itemsQuantity"))
            commandData.setItemsQuantity(cmd.getOptionValue("itemsQuantity"));
        if (cmd.hasOption("eventsCount"))
            commandData.setEventsCount(cmd.getOptionValue("eventsCount"));
        if (cmd.hasOption("outDir"))
            commandData.setOutDir(cmd.getOptionValue("outDir"));
        logger.info("End read parameters");
        return commandData;

    }
    private Options createOptions(){
        Options options = new Options();
        options.addOption("customerIds", "customerIds", true, "Zakres wartosci do pola ID");
        options.addOption("dateRange", "dateRange", true, "Zakres czasowy");
        options.addOption("itemsFile", "itemsFile", true, "Plik ze spisem produktów");
        options.addOption("itemsCount", "itemsCount", true, "Zakres ilosci generowanych elementów");
        options.addOption("itemsQuantity", "itemsQuantity", true, "Zakres");
        options.addOption("eventsCount", "eventsCount", true, "Ilość transakcji");
        options.addOption("outDir", "outDir", true, "Katalog do przechowania pliku");
        return options;
    }
}
