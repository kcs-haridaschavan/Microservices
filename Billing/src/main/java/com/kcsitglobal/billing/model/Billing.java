package com.kcsitglobal.billing.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long billno;
	private Date billingDate;

	public Long getBillno() {
		return billno;
	}

	public void setBillno(Long billno) {
		this.billno = billno;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public Billing(Long billno, Date billingDate) {
		super();
		this.billno = billno;
		this.billingDate = billingDate;
		;
	}

	public Billing() {
		super();
	}

}