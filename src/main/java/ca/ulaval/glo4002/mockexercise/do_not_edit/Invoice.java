package ca.ulaval.glo4002.mockexercise.do_not_edit;

import java.util.List;

// WARNING : do not edit
public class Invoice {
    private final String clientEmail;
    private final List<InvoiceLine> lines;

    public Invoice(String clientEmail, List<InvoiceLine> lines) {
        this.clientEmail = clientEmail;
        this.lines = lines;
    }
}
