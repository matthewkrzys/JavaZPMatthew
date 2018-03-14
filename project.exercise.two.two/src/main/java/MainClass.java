import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        Manager manager=new Manager();
        try {
            manager.getData(args);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
