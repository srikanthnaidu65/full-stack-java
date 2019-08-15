package com.srikanth.fullstackjava;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.srikanth.fullstackjava.Book;

@RunWith(Parameterized.class)
public class BookTest {

	private int inputamount;
	private int discount;
	private int expectedResult;
	private Book book;

	public BookTest(int inputamount,int discount,int expectedresult) {
		this.inputamount=inputamount;
		this.discount=discount;
		this.expectedResult=expectedresult;
	}

	@Before
	public void initialise() {	
		book = new Book();
	}

	@Test
	public void testDiscountedPrice() {
		System.out.println("Testing with: " +inputamount);
		assertEquals(expectedResult, book.discountedPrice(inputamount, discount), 0.0001);
	}
	@Parameterized.Parameters
	public static Collection Words() {
		return Arrays.asList(new Object[][] {
			{ 100, 20, 80 },
			{ 200, 10, 180 },
			{ 300, 30, 210 },
			{ 400, 5, 380 }
		});
	}
}
