package model;

public class Element {
    public String name;
    public int quantity;
    public double price;

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
