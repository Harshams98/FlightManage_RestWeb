package com.flight.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	
	//primary key 
	@Id
	//auto generated
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flightnumber;
	
	private String Carriername;
	
	private String flightmodel;
	
	private int seatcapacity;
	
	//default constructor
	public Flight() {
		super();
	}
	//parameterized constructor
	public Flight(int flightnumber, String carriername, String flightmodel, int seatcapacity) {
		super();
		this.flightnumber = flightnumber;
		Carriername = carriername;
		this.flightmodel = flightmodel;
		this.seatcapacity = seatcapacity;
	}

	public int getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getCarriername() {
		return Carriername;
	}

	public void setCarriername(String carriername) {
		Carriername = carriername;
	}

	public String getFlightmodel() {
		return flightmodel;
	}

	public void setFlightmodel(String flightmodel) {
		this.flightmodel = flightmodel;
	}

	public int getSeatcapacity() {
		return seatcapacity;
	}

	public void setSeatcapacity(int seatcapacity) {
		this.seatcapacity = seatcapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightnumber=" + flightnumber + ", Carriername=" + Carriername + ", flightmodel=" + flightmodel
				+ ", seatcapacity=" + seatcapacity + "]";
	}
	

}
