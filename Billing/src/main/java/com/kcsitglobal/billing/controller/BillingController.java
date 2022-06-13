package com.kcsitglobal.billing.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.billing.model.Billing;
import com.kcsitglobal.billing.service.BillingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing")
public class BillingController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BillingService billingService;

	@GetMapping("/get-bills")
	public Object getbills() {
		@SuppressWarnings("unchecked")
		List<Billing> billing = (List<Billing>) billingService.getBills();
		logger.info(billing.toString());
		return billing;
	}

	@GetMapping("/get-billno")
	public Object getBillById(@RequestParam Long billno) {
		Object billing = billingService.getbillno(billno);
		logger.info(billing.toString());
		return billing;
	}

	/*
	 * @GetMapping("/get-BillingByDate") public Object
	 * getbillingbyDate(@RequestParam Date billingdate) {
	 * 
	 * @SuppressWarnings("unchecked") List<Billing> billing = (List<Billing>)
	 * billingService.getbillingbydate(billingdate);
	 * logger.info(billing.toString()); return billing; }
	 */
	@PostMapping("/add-bills")
	public Object addBilling(@RequestBody Billing billing) {
		logger.info(billing.toString());
		return billingService.addBlling(billing);
	}

	@PutMapping("/update-bill")
	public Object updatebill(@RequestBody Billing billing) {
		logger.info(billing.toString());
		return billingService.updateBill(billing);
	}

	@DeleteMapping("/delete-bill")
	public Object deletebill(@RequestParam Long billno) {
		logger.info("Billingno :" + billno);
		return billingService.deletebill(billno);

	}
}
