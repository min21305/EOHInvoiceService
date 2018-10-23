package com.assignment.eoh.testcases;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.eoh.model.Invoice;
import com.assignment.eoh.model.LineItem;

@RunWith(SpringRunner.class)
public class InvoiceUnitTests {

    private Invoice invoice;
    private List<LineItem> lineItems;

    @Before
    public void setup() {
        invoice = new Invoice();
        lineItems = new ArrayList<LineItem>();
        invoice.setId(1L);
        invoice.setVatRate(15L);
        invoice.setLineItems(lineItems);

        LineItem lineItem1 = new LineItem();
        lineItem1.setId(1L);
        lineItem1.setQuantity(1L);
        lineItem1.setDescription("Pencil");
        lineItem1.setUnitPrice(BigDecimal.valueOf(2.00));

        LineItem lineItem2 = new LineItem();
        lineItem2.setId(2L);
        lineItem2.setQuantity(1L);
        lineItem2.setDescription("Pencil");
        lineItem2.setUnitPrice(BigDecimal.valueOf(2.00));

        invoice.getLineItems().add(lineItem1);
        invoice.getLineItems().add(lineItem2);
    }

    @Test
    public void testSubTotalAndTotalAndVatIsCorrect() {
        assertThat(invoice.getVat().toPlainString()).isEqualTo("0.60");
        assertThat(invoice.getSubTotal().toPlainString()).isEqualTo("4.0");
        assertThat(invoice.getTotal().toPlainString()).isEqualTo("4.60");
    }

}
