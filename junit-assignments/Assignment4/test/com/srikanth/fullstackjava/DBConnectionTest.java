package com.srikanth.fullstackjava;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.srikanth.fullstackjava.DBConnection;

public class DBConnectionTest {
	private String drivername;
	private String url;
	private String uname;
	private String pwd;
	private DBConnection db;
	
	@Before
	public void init() {
		drivername = "com.mysql.jdbc.Driver";
		uname = "root";
		pwd = "root";
		url = "jdbc:mysql://localhost:3306/fullstackjava";
		db = new DBConnection();
	}
	
	@Test
	public void testConnect() {
		assertEquals("true", db.connect(drivername, url, uname, pwd));
	}
	
	@After
	public void destroy () {
		drivername = null;
		uname = null;
		pwd = null;
		url = null;
		db = null;
	}

}
