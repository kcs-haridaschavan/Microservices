package com.kcsitglobal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Customer")

public class Customer {

    private Long cId;
    private String email;
    private String contactName;
   
    List<Purchase> purchase=new ArrayList<>();

	public Customer(Long cId, String email, String contactName, List<Purchase> purchase) {
		super();
		this.cId = cId;
		this.email = email;
		this.contactName = contactName;
		this.purchase = purchase;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}


}
