package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLineFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class StartByTestingThisTest {
    private StartByTestingThis service;
    private CartFactory cartFactoryDependency;
    private ProductRepository productRepositoryDependency;
    private InvoiceLineFactory invoiceLineFactoryDependency;
    private Cart cartDependency;

    private final String clientEmail = "test@gmail.com";
    private final String productSku = "azerty";
    private final Product product1 = new Product(this.productSku, "Test Product", 1.0);
    private final Product product2 = new Product(this.productSku, "Test Product 2", 3.0);
    private final InvoiceLine invoiceLine = new InvoiceLine("test", 1.0);

    @BeforeEach
    public void setUp() {
        cartFactoryDependency = mock(CartFactory.class);
        productRepositoryDependency = mock(ProductRepository.class);
        invoiceLineFactoryDependency = mock(InvoiceLineFactory.class);

        service = new StartByTestingThis(cartFactoryDependency, productRepositoryDependency, invoiceLineFactoryDependency);

        cartDependency = mock(Cart.class);

        when(cartFactoryDependency.create(anyString())).thenReturn(cartDependency);
        when(productRepositoryDependency.findBySku(anyString())).thenReturn(product1);
        when(cartDependency.getProducts()).thenReturn(Arrays.asList(product2, product2));
        when(invoiceLineFactoryDependency.create(anyString(), anyDouble())).thenReturn(invoiceLine);
    }

    @Test
    public void whenOneClickBuy_cartFactoryIsCalled() {
        service.oneClickBuy(clientEmail, productSku);

        verify(cartFactoryDependency).create(clientEmail);
    }

    @Test
    public void whenOneClickBuy_ProductRepositoryFindIsCalled() {
        service.oneClickBuy(clientEmail, productSku);

        verify(productRepositoryDependency).findBySku(productSku);
    }

    @Test
    public void whenOneClickBuy_CartAddProductIsCalled() {
        service.oneClickBuy(clientEmail, productSku);

        verify(this.cartDependency).addProduct(product1);
    }

    @Test
    public void whenOneClickBuy_InvoiceLineCreateIsCalled() {
        service.oneClickBuy(clientEmail, productSku);

        verify(this.invoiceLineFactoryDependency, times(2)).create(anyString(), anyDouble());
    }
}
