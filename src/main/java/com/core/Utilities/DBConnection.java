package com.core.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.ui.Browser;

public class DBConnection {
	
	final static Logger logger = LoggerFactory.getLogger(Browser.class);
	
	public static Connection getConnection(String connection,String driver,String username,String password) {
		Connection con = null;
		try {
			Class.forName(connection);
			con = DriverManager.getConnection(driver,username,password);
		}
		catch(ClassNotFoundException | SQLException e) {
			logger.error("Error in DB connection",e);
			
		}
		return con;
	}

}
