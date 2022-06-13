package com.kcsitglobal.model;

public class Customer {
	private Long custId;
	private String name;
	private Long mobileno;

	public Customer() {
		super();
	}

	public Customer(Long custId, String name, Long mobileno) {
		super();
		this.custId = custId;
		this.name = name;
		this.mobileno = mobileno;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", mobileno=" + mobileno + "]";
	}

}
