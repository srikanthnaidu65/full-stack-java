package com.srikanth.fullstackjava;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public String connect(String drivername, String url, String uname, String pwd) {
		try {
			Class.forName(drivername);
			Connection con = DriverManager.getConnection(url, uname, pwd);
		} catch(Exception e) {
			System.out.println(e);
			return "false";
		}
		return "true";
	}
}
