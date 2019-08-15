package com.srikanth.fullstackjava;

public class Book {
	
	public double discountedPrice(int price, double discount) {	
		return price - (price * discount * 0.01);
	}
}
