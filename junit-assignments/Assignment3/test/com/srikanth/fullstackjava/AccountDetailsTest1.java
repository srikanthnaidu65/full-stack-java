package com.srikanth.fullstackjava;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.srikanth.fullstackjava.AccountDetails;


public class AccountDetailsTest1 {
	
	private AccountDetails ac;


	@Before
	public void initialise() {
		ac = new AccountDetails();
	}

	@Test
	public void testActNo() {
		assertEquals(10056, ac.acctNo(10056));
	}

	@Test
	public void testAcctName() {
		assertEquals("Srikanth", ac.acctName("Srikanth"));
	}

	@Test
	public void testAcctBal() {
		assertEquals(500, ac.acctBalance(500), 0.0001);
	}

}
