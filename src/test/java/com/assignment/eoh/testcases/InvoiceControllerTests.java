package com.assignment.eoh.testcases;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.eoh.controller.InvoiceController;
import com.assignment.eoh.model.Invoice;
import com.assignment.eoh.model.LineItem;
import com.assignment.eoh.service.InvoiceService;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private InvoiceService invoiceService;
	
	private Invoice invoice;
	private List<LineItem> lineItems;
	private List<Invoice> invoiceList;

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

		invoiceList = Collections.singletonList(invoice);
	}

	@Test
	public void testViewAllInvoice() throws Exception {
		Mockito.when(invoiceService.getAllInvoices()).thenReturn(invoiceList);
		mvc.perform(get("/invoices", 1L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$", hasSize(1)))
						.andExpect(jsonPath("$[0].id", is(1)));
	}

	@Test
	public void testViewInvoice() throws Exception {
		Mockito.when(invoiceService.viewInvoice(invoice.getId())).thenReturn(invoice);
		mvc.perform(get("/invoices/{id}", 1L).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.id", is(1)));
	}

}
