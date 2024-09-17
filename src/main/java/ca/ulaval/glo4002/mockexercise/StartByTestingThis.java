package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.*;

import java.util.ArrayList;
import java.util.List;

public class StartByTestingThis {
    private final CartFactory cartFactory;
    private final ProductRepository productRepository;
    private final InvoiceLineFactory invoiceLineFactory;

    StartByTestingThis(CartFactory cartFactoryDependency, ProductRepository ProductRepositoryDependency, InvoiceLineFactory invoiceLineFactory) {
        this.cartFactory = cartFactoryDependency;
        this.productRepository = ProductRepositoryDependency;
        this.invoiceLineFactory = invoiceLineFactory;
    }

    public Invoice oneClickBuy(String clientEmail, String productSku) {
        // Étape 1 : Créer le cart avec le CartFactory
        Cart cart = cartFactory.create(clientEmail);

        // Étape 2 : Trouver le produit avec le ProductRepository
        Product product = productRepository.findBySku(productSku);

        // Étape 3 : Ajouter le produit au cart
        cart.addProduct(product);

        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        List<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
        List<Product> products = cart.getProducts();
        for (Product p : products) {
            invoiceLines.add(invoiceLineFactory.create(p.getName(), p.getPrice()));
        }
        Invoice invoice = new Invoice(clientEmail, invoiceLines);

        // Étape 5 : Retourner l'invoice

        return invoice;
    }
}
