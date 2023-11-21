package com.ey.training.jdbcdemo;

import java.sql.*;
import java.util.Scanner;

class Course{
	
	Connection con=null;
    PreparedStatement pstmt; //Accepts values to queries at run time - precompiled statements
    ResultSet rs; // Virtual Table - Retrieve data and store here.
    
    int count;
    String sqlUpdate;
    Scanner s;
    int cid;
    float fees;
    
    public void getConnection() throws Exception{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection
    			("jdbc:mysql://localhost:3306/college","root","rps@123");
    }
    
    public void UpdateFees() throws Exception {
    	sqlUpdate="UPDATE course SET fees= ? where courseid = ?"; // takes value at runtime
    	
    	pstmt=con.prepareStatement(sqlUpdate); // execute prepared statement
    	
    	// prepare data for update
    	s=new Scanner(System.in);
    	System.out.println("Enter Course Id :");
    	cid=s.nextInt();
    	System.out.println("Enter Updated Fees :");
    	fees=s.nextFloat();
    	
    	// passing values to prepared statement using setter methods
    	pstmt.setFloat(1, fees);
    	pstmt.setInt(2, cid);
    	
    	count=pstmt.executeUpdate();
    	System.out.println("The no. of rows Updated is :"+count);
    	con.close();
    }
    
}
public class UpdateDemo {

	public static void main(String[] args) {
		
		Course c1=new Course();
		
		try {
				c1.getConnection();
				c1.UpdateFees();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}

