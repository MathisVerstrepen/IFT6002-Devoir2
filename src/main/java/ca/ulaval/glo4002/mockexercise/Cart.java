package ca.ulaval.glo4002.mockexercise;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final String email;
    private final List<Product> products = new ArrayList<>();

    public Cart(String email) {
        this.email = email;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }


}
