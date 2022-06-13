package com.kcsitglobal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long BookingId;
	private Date bookingDate;
	private Double bookingTotal;

	@ManyToOne
	@JoinColumn(name = "id")
	private User user;

	public Long getBookingId() {
		return BookingId;
	}

	public void setBookingId(Long bookingId) {
		BookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Double getBookingTotal() {
		return bookingTotal;
	}

	public void setBookingTotal(Double bookingTotal) {
		this.bookingTotal = bookingTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
