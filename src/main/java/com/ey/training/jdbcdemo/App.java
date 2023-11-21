package com.ey.training.jdbcdemo;

/**
 * JDBC PROGRAM to connect to mysql db and fetch record
 *
 */
import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        Connection con = null;
        Statement stmt;
        ResultSet rs; // virtual table
        
        try {
        	//load & register the driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//create connection obj using getConnection()
        	
        	con=DriverManager.getConnection
        			("jdbc:mysql://localhost:3306/classicmodels","root","rps@123");
        	//create statement object
        	stmt=con.createStatement();
        	
        	// execute query and store data in resultset
        	rs=stmt.executeQuery("select * from employees");
        	
        	//traverse resultset
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString("email")+" "+rs.getString(8));
        		
        	}
        	con.close();
        } catch(Exception ex) {
        	ex.printStackTrace();
        	}
        
    }
}
