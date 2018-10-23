package com.assignment.eoh.service;

import java.util.List;

import com.assignment.eoh.model.Invoice;

public interface InvoiceService {

	/**
	 * This method is used to add invoice.
	 * 
	 * @param person
	 * @return invoice as {@link Invoice}
	 */
	Invoice addInvoice(Invoice invoice);

	/**
	 * This method is used to get the single invoice based on the supplied id.
	 * 
	 * @param id
	 * @return invoice as {@link Invoice}
	 */
	Invoice viewInvoice(Long id);

	/**
	 * This method is used to get all the invoices present in the database.
	 * 
	 * @return invoiceList as {@link List}
	 */
	List<Invoice> getAllInvoices();

}
