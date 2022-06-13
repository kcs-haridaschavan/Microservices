package com.kcsitglobal.customerdetails.model;


	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonManagedReference;

	@Entity
	@Table(name = "CUSTOMER")
	public class Customer {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "CUSTID")
		private int custId;
		
		@Column(name = "NAME")
		private String name;
		
	
		
		@Column(name = "MOBILENO")
		private Long mobileno;
		
		
		
		
		/*@OneToMany(cascade = CascadeType.ALL,mappedBy="customer",fetch = FetchType.LAZY)

		private List<Purchase> purchase;
		
		@JsonManagedReference
		public List<Purchase> getPurchase() {
			return purchase;
		}
		public void setpurchase(List<Purchase> purchase) {
			this.purchase = purchase;
		}*/
		
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy="customer",fetch = FetchType.LAZY)
		public List<Billing> billing;
		
		@JsonManagedReference
		public List<Billing> getBilling() {
			return billing;
		}
		public void setProducts(List<Billing> billing) {
			this.billing = billing;
		}
		public Customer() {
			super();
		}
		public Customer(int custId, String name, Long mobileno, List<Billing> billing) {
			super();
			this.custId = custId;
			this.name = name;
			this.mobileno = mobileno;
			this.billing = billing;
		}
		public int getCustId() {
			return custId;
		}
		public void setCustId(int custId) {
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
		public void setBilling(List<Billing> billing) {
			this.billing = billing;
		}
		@Override
		public String toString() {
			return "Customer [custId=" + custId + ", name=" + name + ", mobileno=" + mobileno + ", billing=" + billing
					+ "]";
		}
	}
		


		/*@OneToMany(cascade = CascadeType.ALL,mappedBy="customer",fetch = FetchType.LAZY)
		public List<Contact> contact;
		
		@JsonManagedReference
		public List<Contact> getContact() {
			return contact;
		}
		public void setContact(List<Contact> contacts) {
			this.contact = contacts;
		}
		public int getId() {
			return id;
		}*/
		
		