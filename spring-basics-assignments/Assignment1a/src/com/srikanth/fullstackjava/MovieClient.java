package com.srikanth.fullstackjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		Movie movie = (Movie) context.getBean("movie");
		System.out.println(movie);
	}
}
