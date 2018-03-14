import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ParseToJSON {
    private double sumPrice = 0;
    public JSONData jsonData;

    public void parseCommandData(CommandData commandData) {
        jsonData=new JSONData();
        String[] tCustomerID = commandData.getCustomerID().split(":");
        jsonData.customer_id = randomGenerate(Integer.parseInt(tCustomerID[1]), Integer.parseInt(tCustomerID[0]));
        String[] tDataRange = commandData.getDateRange().split(":");
        jsonData.timestamp = tDataRange[0];
        //przekazac do metody
        commandData.getItemsFile();

        String[] tItemCount = commandData.getItemsCount().split(":");
        int ItemCount = randomGenerate(Integer.parseInt(tItemCount[1]), Integer.parseInt(tItemCount[0]));
        String[] tItemQuantity = commandData.getItemsQuantity().split(":");
        jsonData.items = getItemFile(ItemCount, Integer.parseInt(tItemQuantity[1]), Integer.parseInt(tItemQuantity[0]), commandData.getItemsFile());
        jsonData.sum = sumPrice;
        commandData.getEventsCount();
        JSONGenerate jsonGenerate = new JSONGenerate();
        jsonGenerate.generate(jsonData,commandData.getOutDir());

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
            e.name = elementFileList.get(i%elementFileList.size()).name;
            e.price = elementFileList.get(i%elementFileList.size()).price;
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


}
