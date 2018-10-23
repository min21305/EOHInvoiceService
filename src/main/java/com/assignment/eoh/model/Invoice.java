package com.assignment.eoh.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
public class Invoice implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id", unique = true, nullable = false)
	private Long id;

	private String client;

	private Long vatRate;

	@Temporal(TemporalType.DATE)
	private Date invoiceDate = new Date();

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LineItem> lineItems;

	public BigDecimal getSubTotal() {
		BigDecimal subTotal = BigDecimal.ZERO;
		for (LineItem lineItem : lineItems) {
			subTotal = subTotal.add(lineItem.getLineItemTotal());
		}
		return subTotal;
	}

	public BigDecimal getVat() {
		BigDecimal subTotal = getSubTotal();
		BigDecimal vat = new BigDecimal(vatRate).divide(new BigDecimal(100));
		return subTotal.multiply(vat).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal getTotal() {
		return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
	}
}
