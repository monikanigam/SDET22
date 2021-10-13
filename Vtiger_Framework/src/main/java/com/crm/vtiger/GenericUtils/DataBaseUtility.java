package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con = null;
	ResultSet result = null;
	Driver driverRef;
	
	/**
	 * connection with DB with establish
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
	}
	
	/**
	 * DB connection is closed 
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
	
	/**
	 * get data from DB and verify
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	   public String getDataFromDB(String query, int columnName, String expData) throws Throwable
	   {
		   boolean flag = false;
		   result=con.createStatement().executeQuery(query);
		   while(result.next()) {
			   if(result.getString(columnName).equalsIgnoreCase(expData)) {
				   flag=true;
				   break;
			   }
		   }
		   if(flag) {
			   System.out.println(expData + "data verified in Data base");
			   return expData;
		   }
		   else {
			   System.out.println(expData + "data not verified");
				return expData;
		   }
	   }
}
