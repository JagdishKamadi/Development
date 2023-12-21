package com.epam.dip.Solution;

public class CreditCard implements Cards {

	@Override
	public void doTransaction(int amount) {
		System.out.println("tx done with CreditCard");
	}

}
