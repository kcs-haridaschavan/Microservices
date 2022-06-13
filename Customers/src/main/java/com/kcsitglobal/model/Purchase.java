package com.kcsitglobal.model;

public class Purchase {
	private Long purchaseId;
	private double quantity;
	private double price;
	private Long cId;

	public Purchase() {
		super();
	}

	public Purchase(Long purchaseId, double quantity, double price, Long cId) {
		super();
		this.purchaseId = purchaseId;
		this.quantity = quantity;
		this.price = price;
		this.cId = cId;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

}