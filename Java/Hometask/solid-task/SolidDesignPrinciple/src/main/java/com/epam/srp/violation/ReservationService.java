package com.epam.srp.violation;

public class ReservationService {

	public String search(String source, String destination) {
		// do searchBuses
		return "Buses Found";
	}

	public String bookTicket(int numberOfSeats) {
		// booking the ticket
		return "Ticket Booked";
	}

	public void printTickect() {
		// printing the Ticket
	}

	public void getTravelInsuranceInfo(int ticketId) {
		// getting the Travel Insurance info
	}

	public void sendOTP(String medium) {
		if (medium.equals("email")) {
			// write email related logic
		}
	}
}
