import model.CommandData;
import org.apache.commons.cli.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Manager {
    private static ObjectMapper mapper = new ObjectMapper();

    public void getData(String args[]) throws IOException, ParseException {
        Options options = new Options();
        Option a = Option.builder().argName("customerIds").longOpt("customerIds").hasArg(true).desc("zakres").valueSeparator('=').build();
        options.addOption("customerIds", "customerIds", true, "Zakres wartosci do pola ID");
        options.addOption("dateRange", "dateRange", true, "Zakres czasowy");
        options.addOption("itemsFile", "itemsFile", true, "Plik ze spisem produktów");
        options.addOption("itemsCount", "itemsCount", true, "Zakres ilosci generowanych elementów");
        options.addOption("itemsQuantity", "itemsQuantity", true, "Zakres");
        options.addOption("eventsCount", "eventsCount", true, "Ilość transakcji");
        options.addOption("outDir", "outDir", true, "Katalog do przechowania pliku");

        CommandLineParser parser = new BasicParser();
        CommandLine cmd = null;

        try{
            cmd = parser.parse(options, args);
        }
        catch (ParseException pe){
            System.out.println("Unfortunately, arguments are not right");
            return;
        }

        CommandData commandData=new CommandData();

        if (cmd.hasOption("customerIds"))
            commandData.setCustomerID(cmd.getOptionValue("customerIds"));
        if (cmd.hasOption("dateRange"))
            commandData.setDateRange(cmd.getOptionValue("dateRange"));
        if (cmd.hasOption("itemsFile"))
            commandData.setItemsFile(cmd.getOptionValue("itemsFile"));
        else {
            System.out.println("You haven't passed itemsFile arg");
            return;
        }
        if (cmd.hasOption("itemsCount"))
            commandData.setItemsCount(cmd.getOptionValue("itemsCount"));
        if (cmd.hasOption("itemsQuantity"))
            commandData.setItemsQuantity(cmd.getOptionValue("itemsQuantity"));
        if (cmd.hasOption("eventsCount"))
            commandData.setEventsCount(cmd.getOptionValue("eventsCount"));
        if (cmd.hasOption("outDir"))
            commandData.setOutDir(cmd.getOptionValue("outDir"));

        ParseToJSON parseToJSON=new ParseToJSON();
        parseToJSON.parseCommandData(commandData);

    }
}
