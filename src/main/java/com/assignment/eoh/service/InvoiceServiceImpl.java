package com.assignment.eoh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.eoh.data.InvoiceRepository;
import com.assignment.eoh.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;

	/*
	 * (non-Javadoc)
	 * @see com.assignment.eoh.service.InvoiceService#addInvoice(com.assignment.eoh.model.Invoice)
	 */
	public Invoice addInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	/*
	 * (non-Javadoc)
	 * @see com.assignment.eoh.service.InvoiceService#viewInvoice(java.lang.Long)
	 */
	public Invoice viewInvoice(Long id) {
		return invoiceRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.assignment.eoh.service.InvoiceService#getAllInvoices()
	 */
	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

}
