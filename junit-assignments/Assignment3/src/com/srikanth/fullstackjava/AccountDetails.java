package com.srikanth.fullstackjava;

public class AccountDetails {
	
	public int acctNo(int accNo) {	
		System.out.println(accNo);
		return accNo;
	}

	public String acctName(String name)	{
		System.out.println(name);
		return name;
	}

	public double acctBalance(double balance) {
		System.out.println(balance);
		return balance;
	}

	public String deposit() {
		System.out.println("Deposit");
		return "Deposit";
	}

	public String withdraw() {
		System.out.println("WithDraw");
		return "WithDraw";
	}

	public long creditCard(long cardNo) {
		long cc = cardNo + 1;
		System.out.println("Credit Card: " +cc);
		return cc;
	}
}
