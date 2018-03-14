package model;

import java.util.ArrayList;
import java.util.List;

public class JSONData {
    public int id;
    public String timestamp;
    public int customer_id;
    public List<Element> items = new ArrayList<>();
    public double sum;
    private static int countId=0;

    public JSONData(){
        id=++countId;
    }


}
