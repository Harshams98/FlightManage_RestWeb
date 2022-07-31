package com.flight.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class ScheduledFlight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sfid;
	@OneToOne
	private Flight flight;
	
	private int availableseats;
	@OneToOne
	private Schedule schedule;

	
	public ScheduledFlight() {
		super();
	}


	public ScheduledFlight(int sfid, Flight flight, int availableseats, Schedule schedule) {
		super();
		this.sfid = sfid;
		this.flight = flight;
		this.availableseats = availableseats;
		this.schedule = schedule;
	}


	public int getSfid() {
		return sfid;
	}


	public void setSfid(int sfid) {
		this.sfid = sfid;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public int getAvailableseats() {
		return availableseats;
	}


	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	@Override
	public String toString() {
		return "ScheduledFlight [sfid=" + sfid + ", flight=" + flight + ", availableseats=" + availableseats
				+ ", schedule=" + schedule + "]";
	}

	
}