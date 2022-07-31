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

import com.flight.main.model.Passenger;

import com.flight.main.service.PassengerService;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerservice;

	public PassengerController() {
		super();
	}

	public PassengerController(PassengerService passengerservice) {
		super();
		this.passengerservice = passengerservice;
	}
	
	
	@PostMapping()
	public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger){
		return new ResponseEntity<Passenger>(passengerservice.savePassenger(passenger), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<Passenger> getAllPassenger(){
		return passengerservice.getAllPassenger();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Passenger> getById(@PathVariable ("id")int passUid){
	return new ResponseEntity<Passenger>(passengerservice.getById(passUid),
			HttpStatus.OK);//status -- 200
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Passenger> updatePassenger(@PathVariable ("id")int passUid,
			@RequestBody Passenger passenger){
	return new ResponseEntity<Passenger>(passengerservice.updatePassenger(passenger,passUid),
			HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePassenger(@PathVariable ("id") int passUid){
		//delete employee db
		passengerservice.deletePassenger(passUid);
		return new ResponseEntity<String>("Employee record deleted successfully!",HttpStatus.OK);
	}
	
}
