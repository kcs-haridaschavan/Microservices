package com.kcsitglobal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcsitglobal.model.BookRequest;
import com.kcsitglobal.repository.BookMyShowRespository;

@Service
public class BookMyShowService {

	@Autowired
	private BookMyShowRespository repository;

	public String bookShow(BookRequest bookRequest) {
		BookRequest response = repository.save(bookRequest);
		return "Hi " + response.getUserName() + " your Request for " + response.getShowName() + " on date "
				+ response.getBookingTime() + "Booking successfully..";
	}

	public List<BookRequest> getAllBooking() {
		return repository.findAll();
	}

	public BookRequest getBooking(int bookingId) {
		return repository.findById(bookingId).get();
	}

	public String cancelBooking(int bookingId) {
		repository.deleteById(bookingId);
		return "Booking cancelled with bookingId:" + bookingId;

	}

	public BookRequest updateBooking(BookRequest updateBookRequest, int bookingId) {
		BookRequest dbResponse = repository.findById(bookingId).get();
		dbResponse.setUserName(updateBookRequest.getUserName());
		dbResponse.setBookingTime(updateBookRequest.getBookingTime());
		dbResponse.setPrice(updateBookRequest.getPrice());
		dbResponse.setShowName(updateBookRequest.getShowName());
		dbResponse.setUserCount(updateBookRequest.getUserCount());
		repository.saveAndFlush(dbResponse);
		return dbResponse;

	}
}
