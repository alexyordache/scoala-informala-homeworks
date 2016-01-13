package com.alex.valetparking;

public class ParkingTicket {

	private int ticketNumber;
	
	public ParkingTicket(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public ParkingTicket() {
		this.ticketNumber = 1;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
}
