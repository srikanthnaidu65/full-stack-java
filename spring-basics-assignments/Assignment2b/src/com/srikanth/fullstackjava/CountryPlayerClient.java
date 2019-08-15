package com.srikanth.fullstackjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountryPlayerClient {

	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("springconfig.xml");
		Country c1 = (Country) context.getBean("country1");
		Country c2 = (Country) context.getBean("country2");

		Player p1 = (Player) context.getBean("player");
		p1.setPlayerId("P001");
		p1.setPlayerName("Kohli");
		p1.setCountry(c1);
		System.out.println("Player Id:"+p1.getPlayerId()+", Player Name: "+p1.getPlayerName()
		+" Country Id: "+p1.getCountry().getCountryId()+" CountryName: "+p1.getCountry().getCountryName());

		Player p2 = (Player) context.getBean("player");
		p2.setPlayerId("P002");
		p2.setPlayerName("Dhoni");
		p2.setCountry(c1);
		System.out.println("Player Id:"+p2.getPlayerId()+", Player Name: "+p2.getPlayerName()
		+" Country Id: "+p2.getCountry().getCountryId()+", CountryName: "+p2.getCountry().getCountryName());

		Player p3 = (Player) context.getBean("player");
		p3.setPlayerId("P003");
		p3.setPlayerName("Sachin");
		p3.setCountry(c2);
		System.out.println("Player Id:"+p3.getPlayerId()+", Player Name: "+p3.getPlayerName()
		+" Country Id: "+p3.getCountry().getCountryId()+", CountryName: "+p3.getCountry().getCountryName());

		Player p4 = (Player) context.getBean("player");
		p4.setPlayerId("P004");
		p4.setPlayerName("Rohit");
		p4.setCountry(c2);
		System.out.println("Player Id:"+p4.getPlayerId()+", Player Name: "+p4.getPlayerName()
		+" Country Id: "+p4.getCountry().getCountryId()+", CountryName: "+p4.getCountry().getCountryName());

		Player p5 = (Player) context.getBean("player");
		p5.setPlayerId("P005");
		p5.setPlayerName("Dhawan");
		p5.setCountry(c2);
		System.out.println("Player Id:"+p5.getPlayerId()+", Player Name: "+p5.getPlayerName()
		+" Country Id: "+p5.getCountry().getCountryId()+", CountryName: "+p5.getCountry().getCountryName());

		System.out.println("-----Country 1-----");
		if((p1.getCountry().getCountryName()).equals(c1.getCountryName())) {
			System.out.println(p1.getPlayerName());
		}
		if((p2.getCountry().getCountryName()).equals(c1.getCountryName())) {
			System.out.println(p2.getPlayerName());
		}
		if((p3.getCountry().getCountryName()).equals(c1.getCountryName())) {
			System.out.println(p3.getPlayerName());
		}
		if((p4.getCountry().getCountryName()).equals(c1.getCountryName())) {
			System.out.println(p4.getPlayerName());
		}
		if((p5.getCountry().getCountryName()).equals(c1.getCountryName())) {
			System.out.println(p5.getPlayerName());
		}

		System.out.println("-----Country 2-----");
		if((p1.getCountry().getCountryName()).equals(c2.getCountryName())) {
			System.out.println(p1.getPlayerName());
		}
		if((p2.getCountry().getCountryName()).equals(c2.getCountryName())) {
			System.out.println(p2.getPlayerName());
		}
		if((p3.getCountry().getCountryName()).equals(c2.getCountryName())) {
			System.out.println(p3.getPlayerName());
		}
		if((p4.getCountry().getCountryName()).equals(c2.getCountryName())) {
			System.out.println(p4.getPlayerName());
		}
		if((p5.getCountry().getCountryName()).equals(c2.getCountryName())) {
			System.out.println(p5.getPlayerName());
		}
	}

}
