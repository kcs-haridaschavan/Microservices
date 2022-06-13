package com.kcsitglobal.client.controller;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.kcsitglobal.client.BookRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/BookMyShow-client")
public class BookMyShowWebClientController {

	WebClient webClient;

	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl("http://localhost:9090/BookMyShow/Service")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	@PostMapping("/BookNow")
	public Mono<String> BookNow(@RequestBody BookRequest request) {
		return webClient.post().uri("/bookingShow").syncBody(request).retrieve().bodyToMono(String.class);

	}

	@GetMapping("/trackBookings")
	public Flux<BookRequest> trackAllBooking() {
		return webClient.get().uri("/getAllBooking").retrieve().bodyToFlux(BookRequest.class);
	}

	@GetMapping("/getbooking/{bookingId}")
	public Mono<BookRequest> getBookingById(@PathVariable int bookingId) {
		return webClient.get().uri("/getbooking/" + bookingId).retrieve().bodyToMono(BookRequest.class);
	}

	@DeleteMapping("/removeBooking/{bookingId}")
	public Mono<String> cancelBooking(@PathVariable int bookingId) {
		return webClient.delete().uri("/cancelBooking/" + bookingId).retrieve().bodyToMono(String.class);

	}

	@PutMapping("/changeBooking/{bookingId}")
	public Mono<BookRequest> updateBooking(@PathVariable int bookingId, @RequestBody BookRequest request) {
		return webClient.put().uri("/updateBooking/" + bookingId).syncBody(request).retrieve()
				.bodyToMono(BookRequest.class);
	}
}
