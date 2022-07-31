package com.flight.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingid;

	@OneToOne
	private Users userid;

	private String bookingdate;
//	
	@OneToOne
	private Passenger passengerlist;
//	
	private Double ticketcost;

	@OneToOne
	private Flight flight;

	private int noofpassengers;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public Passenger getPassengerlist() {
		return passengerlist;
	}

	public void setPassengerlist(Passenger passengerString) {
		this.passengerlist = passengerString;
	}

	public Double getTicketcost() {
		return ticketcost;
	}

	public void setTicketcost(Double ticketcost) {
		this.ticketcost = ticketcost;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNoofpassengers() {
		return noofpassengers;
	}

	public void setNoofpassengers(int noofpassengers) {
		this.noofpassengers = noofpassengers;
	}

	public Booking(int bookingid, Users userid, String bookingdate, Passenger passengerlist, Double ticketcost,
			Flight flight, int noofpassengers) {
		super();
		this.bookingid = bookingid;
		this.userid = userid;
		this.bookingdate = bookingdate;
		this.passengerlist = passengerlist;
		this.ticketcost = ticketcost;
		this.flight = flight;
		this.noofpassengers = noofpassengers;
	}

	public Booking() {
		super();
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", userid=" + userid + ", bookingdate=" + bookingdate
				+ ", passengerlist=" + passengerlist + ", ticketcost=" + ticketcost + ", flight=" + flight
				+ ", noofpassengers=" + noofpassengers + "]";
	}

}
