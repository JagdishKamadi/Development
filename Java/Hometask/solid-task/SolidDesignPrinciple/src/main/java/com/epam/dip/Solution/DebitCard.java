package com.epam.dip.Solution;

public class DebitCard implements Cards {

	@Override
	public void doTransaction(int amount) {
		System.out.println("tx done with DebitCard");
	}

}
