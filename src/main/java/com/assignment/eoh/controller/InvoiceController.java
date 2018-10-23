package com.assignment.eoh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.eoh.model.Invoice;
import com.assignment.eoh.service.InvoiceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/invoices", produces = { MediaType.APPLICATION_JSON_VALUE })
@Slf4j
public class InvoiceController {

	@Autowired
	private InvoiceService service;

	@PostMapping
	public Invoice addInvoice(@RequestBody Invoice invoice) {
		log.debug("add Invoice: {}", invoice);
		return service.addInvoice(invoice);
	}

	@GetMapping
	public List<Invoice> viewAllInvoices() {
		log.debug("viewAllInvoices: {}");
		return service.getAllInvoices();
	}

	@GetMapping(path = "/{invoiceId}")
	public Invoice viewInvoice(@PathVariable Long invoiceId) throws Exception {
		if (invoiceId == null) {
			throw new Exception("invoiceId is null " + HttpStatus.BAD_REQUEST);
		}
		return service.viewInvoice(invoiceId);
	}
}
