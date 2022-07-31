package com.flight.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.flight.main.model.Booking;
import com.flight.main.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingservice;

	public BookingController() {
		super();
	}

	public BookingController(BookingService bookingservice) {
		super();
		this.bookingservice = bookingservice;
	}
	
	@PostMapping()
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
		return new ResponseEntity<Booking>(bookingservice.saveBooking(booking), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Booking> getAllBooking(){
		return bookingservice.getAllBooking();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Booking> getById(@PathVariable ("id")int bookingId){
	return new ResponseEntity<Booking>(bookingservice.getById(bookingId),
			HttpStatus.OK);//status -- 200
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable ("id")int bookingId,
			@RequestBody Booking booking){
	return new ResponseEntity<Booking>(bookingservice.updateBooking(booking,bookingId),
			HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id")int bookingId){
		//delete employee db
		bookingservice.deleteBooking(bookingId);
		return new ResponseEntity<String>("Employee record deleted successfully!",HttpStatus.OK);
	}
}
