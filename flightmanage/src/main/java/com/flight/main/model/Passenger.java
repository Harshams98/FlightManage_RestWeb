package com.flight.main.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pnrnumber;
	
	private String passengername;
	
	private int passengerage;
	
	private int passengeruin;
	
	private Double luggage;


	public Passenger() {
		super();
	}

	public Passenger(int pnrnumber, String passengername, int passengerage, int passengeruin, Double luggage) {
		super();
		this.pnrnumber = pnrnumber;
		this.passengername = passengername;
		this.passengerage = passengerage;
		this.passengeruin = passengeruin;
		this.luggage = luggage;
	}

	public int getPnrnumber() {
		return pnrnumber;
	}

	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public int getPassengerage() {
		return passengerage;
	}

	public void setPassengerage(int passengerage) {
		this.passengerage = passengerage;
	}

	public int getPassengeruin() {
		return passengeruin;
	}

	public void setPassengeruin(int passengeruin) {
		this.passengeruin = passengeruin;
	}

	public Double getLuggage() {
		return luggage;
	}

	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}

	@Override
	public String toString() {
		return "Passenger [pnrnumber=" + pnrnumber + ", passengername=" + passengername + ", passengerage="
				+ passengerage + ", passengeruin=" + passengeruin + ", luggage=" + luggage + "]";
	}
	
	
}
