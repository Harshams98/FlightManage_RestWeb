package com.flight.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.main.model.Airport;


@Repository
public interface AirportRepo extends JpaRepository<Airport,String>{

}
