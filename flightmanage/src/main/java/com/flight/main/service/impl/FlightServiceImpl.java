package com.flight.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.main.model.Flight;

import com.flight.main.repository.FlightRepo;
import com.flight.main.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepo flightRepo;

	// default constructor
	public FlightServiceImpl() {
		super();
	}

	// parameterized constructor
	public FlightServiceImpl(FlightRepo flightRepo) {
		super();
		this.flightRepo = flightRepo;
	}

	// insert
	@Override
	public Flight saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepo.save(flight);
	}

	@Override
	public List<Flight> getAllFlights() {
		// TODO Auto-generated method stub
		return flightRepo.findAll();
	}

	@Override
	public Flight getById(int flightnum) {
		Optional<Flight> flghtid = flightRepo.findById(flightnum);

		return flightRepo.findById(flightnum).orElseThrow(() -> // USING LAMBDA
		new com.flight.main.exception.ResourceNotFoundException("flght", "id", flghtid));
	}

	@Override
	public Flight updateFlight(Flight flight, int flightnum) {
		Flight fid = flightRepo.findById(flightnum).orElseThrow(() ->

		new com.flight.main.exception.ResourceNotFoundException("Schedule", "Id", flightnum));
		fid.setSeatcapacity(flight.getSeatcapacity());
		// saving existion employee in db
		flightRepo.save(fid);

		return fid;
	}

	@Override
	public void deleteFlight(int flightnum) {
		flightRepo.findById(flightnum).orElseThrow(
				() -> new com.flight.main.exception.ResourceNotFoundException("Flight", "number", flightnum));
		flightRepo.deleteById(flightnum);

	}

}
