package com.kcsitglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kcsitglobal.model.Room;
import com.kcsitglobal.service.BookingService;
import com.kcsitglobal.service.RoomService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private RoomService roomService;

	@GetMapping(value = "/booking/{roomId}")
	public String getRoomIdForBooking(@PathVariable Long roomId, Model model) {
		Room room = roomService.findRoomByRoomId(roomId);

		model.addAttribute("room", room);
		model.addAttribute("roomId", roomId);

		return "booking";
	}

}
