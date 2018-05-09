package model;

import java.util.ArrayList;
import java.util.List;

public class JSONData {
    public final int id;
    public final String timestamp;
    public final int customer_id;
    public List<Element> items = new ArrayList<>();
    public final double sum;
    private static int countId=0;


    public JSONData(String timestamp, int customer_id,List<Element> items, double sum) {
        this.timestamp = timestamp;
        this.customer_id = customer_id;
        this.items=items;
        this.sum = sum;
        id=++countId;
    }

    @Override
    public String toString() {
        return "JSONData{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", customer_id=" + customer_id +
                ", items=" + items +
                ", sum=" + sum +
                '}';
    }
}
