package ca.ulaval.glo4002.mockexercise.do_not_edit;

import ca.ulaval.glo4002.mockexercise.Cart;

// WARNING : do not edit
public class CartFactory {
    public Cart create(String email) {
        return new Cart(email);
    }
}
