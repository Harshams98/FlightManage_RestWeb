package com.flight.main.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.main.model.Passenger;
import com.flight.main.repository.PassengerRepo;
import com.flight.main.service.PassengerService;




@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerRepo passengerrepo;
	

	public PassengerServiceImpl() {
		super();
	}

	public PassengerServiceImpl(PassengerRepo passengerrepo) {
		super();
		this.passengerrepo = passengerrepo;
	}

	@Override
	public Passenger savePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		return passengerrepo.save(passenger);
	}

	@Override
	public List<Passenger> getAllPassenger() {
		// TODO Auto-generated method stub
		return passengerrepo.findAll();
	}

	@Override
	public Passenger getById(int passUid) {
		Optional<Passenger> pass=passengerrepo.findById(passUid);
		
		return passengerrepo.findById(passUid).orElseThrow(()->		//USING LAMBDA
				new com.flight.main.exception.ResourceNotFoundException("Airport","airportcode",pass));	
	}

	@Override
	public Passenger updatePassenger(Passenger passenger, int passUid) {
		Passenger passUpd=passengerrepo.findById(passUid).orElseThrow(() ->
		
		new com.flight.main.exception.ResourceNotFoundException("Airport","code",passUid));
			passUpd.setPassengername(passenger.getPassengername());
			passUpd.setPassengerage(passenger.getPassengerage());
			passUpd.setPassengeruin(passenger.getPassengeruin());
			passUpd.setLuggage(passenger.getLuggage());
			//saving existion employee in db
			passengerrepo.save(passUpd);

				return passUpd;
	}

	@Override
	public void deletePassenger(int Uid) {
		passengerrepo.findById(Uid).orElseThrow( ()->
		new com.flight.main.exception.ResourceNotFoundException("Airport","code",Uid));
		passengerrepo.deleteById(Uid);
		
	}

}