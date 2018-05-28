package generatortransakcjispring.generatortransakcji.model;

import java.math.BigDecimal;
import java.util.List;

public class DataTransaction {
    private final int id;
    private final String timestamp;
    private final int customer_id;
    private List<Element> items;
    private final BigDecimal sum;
    private static int countId=0;


    public DataTransaction(String timestamp, int customer_id,List<Element> items, BigDecimal sum) {
        this.timestamp = timestamp;
        this.customer_id = customer_id;
        this.items=items;
        this.sum = sum;
        id=++countId;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public List<Element> getItems() {
        return items;
    }

    public void setItems(List<Element> items) {
        this.items = items;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        DataTransaction.countId = countId;
    }

    @Override
    public String toString() {
        return "DataTransaction{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", customer_id=" + customer_id +
                ", items=" + items +
                ", sum=" + sum +
                '}';
    }
}
