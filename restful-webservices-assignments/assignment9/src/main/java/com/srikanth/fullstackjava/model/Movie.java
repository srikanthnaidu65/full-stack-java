package com.srikanth.fullstackjava.model;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  

@XmlRootElement  
public class Movie {
	private String movieId;
	private String movieName;
	private String movieActor;
	private Float movieCollection;

	public Movie() {

	}

	public Movie(String movieId, String movieName,
			String movieActor, Float movieCollection) {
		this.movieId=movieId;
		this.movieName=movieName;
		this.movieActor=movieActor;
		this.movieCollection=movieCollection;
	}

	@XmlAttribute 
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	@XmlElement
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	@XmlElement
	public String getMovieActor() {
		return movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	@XmlElement
	public Float getMovieCollection() {
		return movieCollection;
	}
	public void setMovieCollection(Float movieCollection) {
		this.movieCollection = movieCollection;
	}

}