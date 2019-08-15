package com.srikanth.fullstackjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;

public class App 
{
	public static void main( String[] args ){
		System.out.println( StringUtils.deleteWhitespace("s    ri   kan      th"));
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myspring", "root", "root");
			Statement stmt = con.createStatement();  
			stmt.executeUpdate("insert into student values(4, 'srikanth', 'Bangalre')");
			ResultSet rs = stmt.executeQuery("select * from student"); 
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ "  " +rs.getString(2)+ "  " +rs.getString(3));  
			}
		}
		catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
}
