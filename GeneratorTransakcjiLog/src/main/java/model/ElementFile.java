package model;

public class ElementFile {
    public final String name;
    public final double price;

    public ElementFile(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ElementFile{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
