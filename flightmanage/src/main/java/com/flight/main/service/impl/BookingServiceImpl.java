package com.flight.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.main.model.Booking;
import com.flight.main.repository.BookingRepo;

import com.flight.main.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepo bookingrepo;

	public BookingServiceImpl() {
		super();
	}

	public BookingServiceImpl(BookingRepo bookingrepo) {
		super();
		this.bookingrepo = bookingrepo;
	}

	@Override
	public Booking saveBooking(Booking booking) {

		return bookingrepo.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {

		return bookingrepo.findAll();
	}

	@Override
	public Booking getById(int bookingId) {
		Optional<Booking> bookings = bookingrepo.findById(bookingId);

		return bookingrepo.findById(bookingId).orElseThrow(() -> // USING LAMBDA
		new com.flight.main.exception.ResourceNotFoundException("Airport", "airportcode", bookings));
	}

	@Override
	public Booking updateBooking(Booking booking, int bookingId) {

		// we need to check wether

		Booking boks = bookingrepo.findById(bookingId).orElseThrow(() ->

		new com.flight.main.exception.ResourceNotFoundException("Airport", "code", bookingId));
		// setting values
		// aircode.setAirportname(Booking.getAirportname());
		boks.setBookingdate(booking.getBookingdate());
		boks.setFlight(booking.getFlight());
		boks.setNoofpassengers(booking.getNoofpassengers());
		boks.setPassengerlist(booking.getPassengerlist());
		boks.setTicketcost(booking.getTicketcost());
		boks.setUserid(booking.getUserid());
		// saving existion employee in db
		bookingrepo.save(boks);

		return boks;
	}

	@Override
	public void deleteBooking(int bookingId) {
		bookingrepo.findById(bookingId).orElseThrow(
				() -> new com.flight.main.exception.ResourceNotFoundException("Airport", "code", bookingId));
		bookingrepo.deleteById(bookingId);

	}
}