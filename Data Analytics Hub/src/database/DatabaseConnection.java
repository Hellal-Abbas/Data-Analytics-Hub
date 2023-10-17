package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This class provides a method to establish a connection to the SQLite database.
public class DatabaseConnection {
	// URL for connecting to the SQLite database.
	private static final String DB_URL = "jdbc:sqlite:DataAnalyticsHub.db";

	// Method to obtain a database connection using the specified URL.
	public static Connection getConnection() throws SQLException {
		// Establishing a connection to the SQLite database and returning the Connection
		// object.
		return DriverManager.getConnection(DB_URL);
	}
}
