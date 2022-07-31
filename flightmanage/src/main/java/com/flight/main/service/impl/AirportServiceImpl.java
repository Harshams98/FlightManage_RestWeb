package com.flight.main.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flight.main.model.Airport;
import com.flight.main.repository.AirportRepo;
import com.flight.main.service.AirportService;




@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepo airportRepo;
	
	public AirportServiceImpl(AirportRepo airportRepo) {
		super();
		this.airportRepo = airportRepo;
	}

	public AirportServiceImpl() {
		super();
	}

	@Override
	public Airport saveAirport(Airport airport) {
		return airportRepo.save(airport);
	}

	@Override
	public List<Airport> getAllAirport() {
		// TODO Auto-generated method stub
		return airportRepo.findAll();
	}

	@Override
	public Airport getById(String airportcode) {
		Optional<Airport> aircode=airportRepo.findById(airportcode);
		
		return airportRepo.findById(airportcode).orElseThrow(()->		//USING LAMBDA
				new com.flight.main.exception.ResourceNotFoundException("Airport","airportcode",aircode));
		}

	@Override
	public Airport updateAirport(Airport airport, String airportcode) {


	// we need to check wether
		
		Airport aircode=airportRepo.findById(airportcode).orElseThrow(() ->
				
				new com.flight.main.exception.ResourceNotFoundException("Airport","code",airportcode));
		aircode.setAirportname(airport.getAirportname());
		
		//saving existion employee in db
		airportRepo.save(aircode);
		
		return aircode;
		
	}

	@Override
	public void deleteEmployee(String airportcode) {
		airportRepo.findById(airportcode).orElseThrow( ()->
		new com.flight.main.exception.ResourceNotFoundException("Airport","code",airportcode));
		airportRepo.deleteById(airportcode);
		
	}
	}


