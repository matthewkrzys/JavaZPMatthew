import model.Element;
import model.ElementFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteFromCSV {
    Generate generate;
    private double sumPrice;
    public WriteFromCSV() {
        generate=new Generate();
    }

    public List<Element> getItemFile(int itemCount, int maxValueQuantity, int minValueQuantity, String itemsFile) {
        List<Element> elementList = new ArrayList<>();
        List<ElementFile> elementFileList = getElementFromFile(itemsFile);
        sumPrice=0;
        for (int i = 0; i < itemCount; i++) {
            Element e = new Element(
                    elementFileList.get(i % elementFileList.size()).name,
                    generate.randomGenerate(maxValueQuantity, minValueQuantity),
                    elementFileList.get(i % elementFileList.size()).price
            );
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
            ElementFile e = new ElementFile(
                    tNap[0].replace("\"", ""),
                    Double.parseDouble(tNap[1])
            );
            elementFileList.add(e);
        }
        return elementFileList;
    }
}
