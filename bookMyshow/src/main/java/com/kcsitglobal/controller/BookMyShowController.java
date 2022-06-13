package com.kcsitglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.model.BookRequest;
import com.kcsitglobal.service.BookMyShowService;

@RestController
@RequestMapping("/BookMyShow/Service")
public class BookMyShowController {

	@Autowired
	private BookMyShowService bookMyShowservice;

	@PostMapping("/bookingShow")
	public String bookShow(@RequestBody BookRequest bookRequest) {
		return bookMyShowservice.bookShow(bookRequest);

	}

	@GetMapping("/getAllBooking")
	public List<BookRequest> getAllBooking() {
		return bookMyShowservice.getAllBooking();
	}

	@GetMapping("/getbooking/{bookingId}")
	public BookRequest getBooking(@PathVariable int bookingId) {
		return bookMyShowservice.getBooking(bookingId);
	}

	@DeleteMapping("/cancelBooking/{bookingId}")
	public String cancelBooking(@PathVariable int bookingId) {
		bookMyShowservice.cancelBooking(bookingId);
		return "Booking cancelled with bookingId:" + bookingId;

	}

	@PutMapping("/updateBooking/{bookingId}")
	public BookRequest updateBooking(@RequestBody BookRequest updateBookRequest, @PathVariable int bookingId) {

		return bookMyShowservice.updateBooking(updateBookRequest, bookingId);
	}
}
