package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.mock;

public class StartByTestingThisTest {
    private CartFactory cartFactoryMock;
    private ProductRepository productRepositoryMock;
    private StartByTestingThis service;
    private Cart cartMock;
    private final Product product = new Product("0", "0", 10);

    @BeforeEach
    public void setUp() {
        cartFactoryMock = mock(CartFactory.class);
        productRepositoryMock = mock(ProductRepository.class);

        cartMock = mock(Cart.class);
        when(cartFactoryMock.create(anyString())).thenReturn(cartMock);
        when(productRepositoryMock.findBySku(anyString())).thenReturn(product);

        service = new StartByTestingThis(cartFactoryMock, productRepositoryMock);
    }


    @Test
    public void whenOneClickBuyUsed_thenCartFactoryIsCalled() {
        service.oneClickBuy("test2", "0");
        verify(cartFactoryMock, times(1)).create("test2");
    }

    @Test
    public void whenOnClickBuyUsed_thenProductRepositoryIsCalled() {
        service.oneClickBuy("test", "0");
        verify(productRepositoryMock, times(1)).findBySku("0");
    }

    @Test
    public void whenOneClickBuyUsed_thenCartAddIsCalled() {
        service.oneClickBuy("test", "0");

        verify(cartMock, times(1)).addProduct(product);
    }
}
