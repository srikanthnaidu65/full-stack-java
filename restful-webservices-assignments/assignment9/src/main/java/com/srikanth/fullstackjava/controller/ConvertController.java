package com.srikanth.fullstackjava.controller;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srikanth.fullstackjava.model.Movie;

@Controller
public class ConvertController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/convert")
	public @ResponseBody List<Movie> convert(){		

		List<Movie> mlist = createMovies();
		return mlist;
	}

	@GetMapping("/convertXml")
	public @ResponseBody StringWriter convertxml() throws FileNotFoundException, JAXBException {		

		List<Movie> mlist = createMovies();

		JAXBContext contextObj = JAXBContext.newInstance(Movie.class);  

		Marshaller marshallerObj = contextObj.createMarshaller();  
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		StringWriter sw = new StringWriter();

		for (Movie m: mlist) {
			marshallerObj.marshal(m, sw);
		}

		System.out.println(sw);

		return sw;

	}
	@GetMapping("/fetchMovie")
	public @ResponseBody StringWriter find(@RequestParam("id") String id) throws FileNotFoundException, JAXBException {		

		List<Movie> mlist = createMovies();

		JAXBContext contextObj = JAXBContext.newInstance(Movie.class);  

		Marshaller marshallerObj = contextObj.createMarshaller();  
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
		StringWriter sw = new StringWriter();
		for(Movie m: mlist) {
			if(m.getMovieId().equals(id)) {
				marshallerObj.marshal(m, sw);
			}
		}
		return sw;
	}

	private List<Movie> createMovies() {

		List<Movie> mlist= new ArrayList<Movie>();
		Movie m1 = new Movie("M001", "Movie1", "Actor1", 35f);
		Movie m2 = new Movie("M002", "Movie2", "Actor2", 35f);
		Movie m3 = new Movie("M003", "Movie3", "Actor3", 35f);
		Movie m4 = new Movie("M004", "Movie4", "Actor4", 35f);
		Movie m5 = new Movie("M005", "Movie5", "Actor5", 35f);
		Movie m6 = new Movie("M006", "Movie6", "Actor6", 35f);
		Movie m7 = new Movie("M007", "Movie7", "Actor7", 35f);
		Movie m8 = new Movie("M008", "Movie8", "Actor8", 35f);
		Movie m9 = new Movie("M009", "Movie9", "Actor9", 35f);
		Movie m10 = new Movie("M0010", "Movie10", "Actor10", 35f);

		mlist.add(m1);
		mlist.add(m2);
		mlist.add(m3);
		mlist.add(m4);
		mlist.add(m5);
		mlist.add(m6);
		mlist.add(m7);
		mlist.add(m8);
		mlist.add(m9);
		mlist.add(m10);

		return mlist;
	}

}

