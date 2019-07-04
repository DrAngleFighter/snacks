package com.icss.snacks.util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Database factory
 * @author zly
 *
 */
public class DbFactory {

	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	/**
	 * @return connection
	 * @throws Exception
	 */
	public static Connection openConnection() throws Exception {
		Connection connection = tl.get();
		if(connection == null || connection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String DB_URL = "jdbc:mysql://localhost/snacks";
			final String USER_NAME = "root";
			final String PASSWORD = "root";
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			tl.set(connection);
		}
		return connection;
	}
	
	public static void closeConnection() throws Exception {
		Connection connection = DbFactory.openConnection();
		connection.close();
	}
	
	public static void beginTransaction() throws Exception {
		Connection connection = DbFactory.openConnection();
		connection.setAutoCommit(false);
	}
	
	public static void commit() throws Exception {
		Connection connection = DbFactory.openConnection();
		connection.commit();
	}
	
	public static void rollback() throws Exception {
		Connection connection = DbFactory.openConnection();
		connection.rollback();
	}


//	public static void main(String[] args) throws Exception {
//		DbFactory.openConnection();
//		DbFactory.closeConnection();
//	}
	
}
