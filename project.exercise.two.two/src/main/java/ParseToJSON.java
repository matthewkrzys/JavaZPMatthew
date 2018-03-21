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

    public void parseCommandData(CommandData commandData) {
        jsonData = new JSONData();
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
            jsonData.customer_id = randomGenerate(Integer.parseInt(tCustomerID[1]), Integer.parseInt(tCustomerID[0]));
            jsonData.timestamp = generatedata(tDataRange[0]+":"+tDataRange[1]+":"+tDataRange[2],tDataRange[3]+":"+tDataRange[4]+":"+tDataRange[5]);
            ItemCount = randomGenerate(Integer.parseInt(tItemCount[1]), Integer.parseInt(tItemCount[0]));
            jsonData.items = getItemFile(ItemCount, Integer.parseInt(tItemQuantity[1]), Integer.parseInt(tItemQuantity[0]), commandData.getItemsFile());
            jsonData.sum = sumPrice;
            jsonGenerate.generate(jsonData, commandData.getOutDir(), i);
        }

    }

    public int randomGenerate(int max, int min) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public List<Element> getItemFile(int itemCount, int maxValueQuantity, int minValueQuantity, String itemsFile) {
        List<Element> elementList = new ArrayList<>();
        List<ElementFile> elementFileList = getElementFromFile(itemsFile);
        for (int i = 0; i < itemCount; i++) {
            Element e = new Element();
            e.name = elementFileList.get(i % elementFileList.size()).name;
            e.price = elementFileList.get(i % elementFileList.size()).price;
            e.quantity = randomGenerate(maxValueQuantity, minValueQuantity);
            elementList.add(e);
            sumPrice += e.price * e.quantity;
        }
        return elementList;
    }

    public List<ElementFile> getElementFromFile(String itemsFile) {
        List<ElementFile> elementFileList = new ArrayList<>();
        File file = new File(itemsFile);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in.nextLine();
        while (in.hasNext()) {
            String nap = in.nextLine();
            String[] tNap = nap.split(",");
            ElementFile e = new ElementFile();
            e.name = tNap[0].replace("\"", "");
            e.price = Double.parseDouble(tNap[1]);
            elementFileList.add(e);
        }
        return elementFileList;
    }
    public String generatedata(String FirstDate,String SecondDate){
        Random random=new Random();
        LocalDateTime start = LocalDateTime.parse(FirstDate.replace("-0100",""));
        LocalDateTime end = LocalDateTime.parse(SecondDate.replace("-0100",""));
        long amount = start.until(end, ChronoUnit.NANOS);
        if (amount < 0) throw new IllegalArgumentException();
        long generatedDate = (long) (random.nextFloat() * amount);
        return start.plusNanos(generatedDate).toString()+"-0100";
    }


}
