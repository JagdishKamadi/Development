package com.epam.dip.Solution;

//Loosely Coupled 
public class TicketBookingApp {
	private Cards bankCard;

	public TicketBookingApp(Cards bankCard) {
		super();
		this.bankCard = bankCard;
	}
	
	public void doPayment(int noOfTickets, int amount) {
		bankCard.doTransaction(amount);
	}
	
	public static void main(String[] args) {
		Cards debitCard = new DebitCard();
		debitCard.doTransaction(25000);
	}
}
