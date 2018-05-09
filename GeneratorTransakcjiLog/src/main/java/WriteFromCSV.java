import model.Element;
import model.ElementFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteFromCSV {
    final static Logger logger = LoggerFactory.getLogger(WriteFromCSV.class);
    final static String TAG= WriteFromCSV.class.getName();
    Generate generate;
    private double sumPrice;
    public WriteFromCSV() {
        generate=new Generate();
    }

    public List<Element> getItemFile(int itemCount, int maxValueQuantity, int minValueQuantity, String itemsFile) {
        logger.info(TAG+" getItemFile args "+itemCount+ " "+maxValueQuantity+" "+minValueQuantity+" "+itemsFile);
        List<Element> elementList = new ArrayList<>();
        List<ElementFile> elementFileList = getElementFromFile(itemsFile);
        logger.info(TAG+" elementFileList "+elementFileList);
        sumPrice=0;
        for (int i = 0; i < itemCount; i++) {
            Element e = new Element(
                    elementFileList.get(i % elementFileList.size()).name,
                    generate.randomGenerate(maxValueQuantity, minValueQuantity),
                    elementFileList.get(i % elementFileList.size()).price
            );
            logger.info(TAG+" Element "+i+" "+e.toString());
            elementList.add(e);
            sumPrice += e.price * e.quantity;
        }
        return elementList;
    }

    public List<ElementFile> getElementFromFile(String itemsFile) {
        logger.info(TAG+" getElementFromFile args "+itemsFile);
        List<ElementFile> elementFileList = new ArrayList<>();
        String path = System.getProperty("user.dir").replace("/build","").replace("/libs","");
        File file = new File(path+"/src/main/resources/"+itemsFile);
        logger.info(TAG+" Path file "+file.getAbsolutePath());
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
            logger.info(TAG+" ElementFile "+e.toString());
            elementFileList.add(e);
        }
        return elementFileList;
    }
}
