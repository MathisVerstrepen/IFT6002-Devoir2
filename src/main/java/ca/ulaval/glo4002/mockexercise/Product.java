package ca.ulaval.glo4002.mockexercise;

public class Product {
    private final String sku;

    public String getName() {
        return name;
    }

    private final String name;

    public double getPrice() {
        return price;
    }

    private final double price;

    public Product(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }
}
