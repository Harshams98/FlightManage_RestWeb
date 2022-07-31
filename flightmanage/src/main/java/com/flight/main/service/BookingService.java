package com.flight.main.service;

import java.util.List;


import com.flight.main.model.Booking;

public interface BookingService {

	Booking saveBooking (Booking booking);
	
	List<Booking> getAllBooking();
	
	Booking getById (int bookingId);
	
	Booking updateBooking(Booking booking,int bookingId);
	
	void deleteBooking(int bookingId);
}
