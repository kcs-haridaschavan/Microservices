package com.kcsitglobal.billing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.google.gson.JsonObject;
import com.kcsitglobal.billing.model.Billing;
import com.kcsitglobal.billing.repository.BillingRepositroy;

@Service
public class BillingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BillingRepositroy billingRepository;

	public List<Billing> getBills() {
		return billingRepository.findAll();

	}

	/*
	 * public List<Billing> getbillingbydate(Date billingdate) { return
	 * billingRepository.findByBillingdate(billingdate); }
	 */

	public Object addBlling(Billing billing) {
		logger.info(billing.toString());
		billingRepository.save(billing);
		logger.info("bill Addded Sucessfully");
		return new ResponseEntity<>("bill Added Sucessfully", HttpStatus.CREATED);
	}

	public Object updateBill(Billing billing) {

		JsonObject response = new JsonObject();
		System.out.println("Request Billing:" + billing);
		Long id = billing.getBillno();
		try {
			Billing bill = billingRepository.getOne(id);
			System.out.println("Request Billing:" + bill);
			System.out.println("Old Billing:" + bill);
			bill.setBillingDate(bill.getBillingDate());
			System.out.println("New Customer:" + bill);
			billingRepository.save(bill);

		} catch (Exception e) {
			logger.info(e.getMessage());
			response.addProperty("statusCode", 404);
			response.addProperty("statusCode", e.getMessage());
			return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);

		}
		logger.info("bill Updated Sucessfully");
		return new ResponseEntity<>("bill Updated Sucessfully", HttpStatus.OK);
	}

	public Object deletebill(Long billno) {
		try {
			billingRepository.deleteById(billno);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		logger.info("Bill Deleted Sucesfully");
		return new ResponseEntity<>("Bill Deleted sucessfully", HttpStatus.OK);

	}

	public Object getbillno(Long billno) {

		return billingRepository.findById(billno);
	}
}
