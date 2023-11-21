package com.ey.training.jdbcdemo;
import java.sql.*;
public class InsertDemo {

	public static void main(String[] args) {
		Connection con = null;
        Statement stmt;
        ResultSet rs; // virtual table
        int count;
        
        try {
        	//load & register the driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//create connection obj using getConnection()
        	
        	con=DriverManager.getConnection
        			("jdbc:mysql://localhost:3306/college","root","rps@123");
        	//create statement object
        	stmt=con.createStatement();
        	String str = "insert into course values(107,'petrolEngg',6500,'petr@gmail.com')";
        	
        			
        	
        	//dml operations are executed with executeupdate() statement
        	
        	count = stmt.executeUpdate(str);
        	
        	if(count>0) {
        		System.out.println("Reecord inserted succesfully");
        	} con.close();
        	
        }
        catch(Exception ex) {
        	ex.printStackTrace();
        	}

	}

}
