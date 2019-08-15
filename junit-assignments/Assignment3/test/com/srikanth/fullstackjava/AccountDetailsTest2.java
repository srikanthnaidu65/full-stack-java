package com.srikanth.fullstackjava;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.srikanth.fullstackjava.AccountDetails;

public class AccountDetailsTest2 {

	private AccountDetails ac;

	@Before
	public void initialise() {	
		ac = new AccountDetails();
	}

	@Test
	public void testDeposit() {
		assertEquals("Deposit", ac.deposit());
	}

	@Test
	public void testWithdraw() {
		assertEquals("WithDraw", ac.withdraw());
	}

	@Test
	public void testCreditcard() {
		assertEquals(123457, ac.creditCard(123456));
	}

}
