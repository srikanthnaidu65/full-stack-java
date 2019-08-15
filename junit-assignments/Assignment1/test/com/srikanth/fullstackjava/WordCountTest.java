package com.srikanth.fullstackjava;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.srikanth.fullstackjava.WordCount;


@RunWith(Parameterized.class)
public class WordCountTest {
	private String inputString;
	private int expectedResult;
	private WordCount wc;

	@Before
	public void init() {
		wc = new WordCount();
	}

	@Test
	public void testWcount() {
		System.out.println("Testing with: " +inputString);
		assertEquals(expectedResult, wc.wcount(inputString));
	}

	public WordCountTest(String inputString, int expectedResult){
		this.inputString = inputString;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection Words() {
		return Arrays.asList(new Object[][] {
			{ "Junit assignments", 2 },
			{ "done by srikanth", 3 },
			{ "from bangalore", 2 },
			{ "I am fullstack", 3 },
			{ "java developer", 2 }
		});
	}
}

