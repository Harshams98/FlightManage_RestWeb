package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.main.model.Passenger;

public interface  PassengerRepo extends JpaRepository<Passenger,Integer> {

}
