package com.ey.training.jdbcdemo;
import java.sql.*;
public class SelectDemo {

	public static void main(String[] args) {
		Connection con = null;
        Statement stmt;
        ResultSet rs; // virtual table
        
        try {
        	//load & register the driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//create connection obj using getConnection()
        	
        	con=DriverManager.getConnection
        			("jdbc:mysql://localhost:3306/college","root","rps@123");
        	//create statement object
        	stmt=con.createStatement();
        	
        	// execute query and store data in resultset
        	rs=stmt.executeQuery("select courseid,coursename,fees from course");
        	
        	//traverse resultset
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
        		
        	}
        	con.close();
        } catch(Exception ex) {
        	ex.printStackTrace();
        	}

	}

}
