package com.srikanth.fullstackjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieClient {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Movie movie = context.getBean("movie", Movie.class);
		System.out.println(movie);
	}

}
