package com.srikanth.fullstackjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name = "movie")
	public Movie getMovie(){
		Movie movie = new Movie("M001", "The Firm", "Tom Cruise");
		return  movie;
	}
}
