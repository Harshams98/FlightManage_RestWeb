package com.flight.main.service;

import java.util.List;

import com.flight.main.model.Passenger;

public interface PassengerService {
	
Passenger savePassenger (Passenger passenger);
	
	List<Passenger> getAllPassenger();
	
	Passenger getById (int passUid);
	
	Passenger updatePassenger(Passenger passenger,int passUid);
	
	void deletePassenger(int Uid);

}