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

import com.flight.main.model.Flight;

import com.flight.main.service.FlightService;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;

	public FlightController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}

	public FlightController() {
		super();
	}

	@PostMapping()
	public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
		return new ResponseEntity<Flight>(flightService.saveFlight(flight), HttpStatus.CREATED);
	}

	@GetMapping()
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@GetMapping("{id}")
	public ResponseEntity<Flight> getById(@PathVariable("id") int flightnum) {
		return new ResponseEntity<Flight>(flightService.getById(flightnum), HttpStatus.OK);// status -- 200
	}

	@PutMapping("{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable("id") int flightnum, @RequestBody Flight flight) {
		return new ResponseEntity<Flight>(flightService.updateFlight(flight, flightnum), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFlight(@PathVariable("id") int flightnum) {
		// delete employee db
		flightService.deleteFlight(flightnum);
		return new ResponseEntity<String>("Flight record deleted successfully!", HttpStatus.OK);
	}

}
