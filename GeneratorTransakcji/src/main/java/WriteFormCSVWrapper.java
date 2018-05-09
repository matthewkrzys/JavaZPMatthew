import model.Element;
import model.ElementFile;

import java.util.List;

public class WriteFormCSVWrapper extends WriteFromCSV {

    public WriteFormCSVWrapper() {
        super();
    }
    public List<Element> getItemFile(int itemCount, int maxValueQuantity, int minValueQuantity, String itemsFile) {
        return super.getItemFile(itemCount,maxValueQuantity,minValueQuantity,itemsFile);
    }
    public List<ElementFile> getElementFromFile(String itemsFile) {
        return super.getElementFromFile(itemsFile);
    }
}
