package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JSONData {
    public final int id;
    public final String timestamp;
    public final int customer_id;
    public List<Element> items = new ArrayList<>();
    public final BigDecimal sum;
    private static int countId=0;


    public JSONData(String timestamp, int customer_id,List<Element> items, BigDecimal sum) {
        this.timestamp = timestamp;
        this.customer_id = customer_id;
        this.items=items;
        this.sum = sum;
        id=++countId;
    }
}
