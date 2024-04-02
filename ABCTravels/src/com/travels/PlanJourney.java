package com.travels;

public class PlanJourney {

	String Source;

	String destination;

	String date;

	int Passengers;
	
	int bookedSeats;

	public PlanJourney(String source, String destination, String date, int passengers) {
		Source = source;
		this.destination = destination;
		this.date = date;
		Passengers = passengers;
	}

	@Override
	public String toString() {
		return "PlanJourney [Source=" + Source + ", destination=" + destination + ", date=" + date + ", Passengers="
				+ Passengers + ", bookedSeats=" + "]";
	}

	public String getSource() {
		return Source;
	}

	public PlanJourney() {
		super();
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPassengers() {
		return Passengers;
	}

	public void setPassengers(int passengers) {
		Passengers = passengers;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	

}
