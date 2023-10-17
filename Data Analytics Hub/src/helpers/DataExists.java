package helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import database.DatabaseConnection;

//This class provides methods to check the existence of specific data in the database.
public class DataExists {
	// Method to check if the given username exists in the 'Users' table.
	public static String usernameExists(String Username) {
		// Defining the table name in the database.
		final String TABLE_NAME = "Users";
		String result = null;
		String usernameResult = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to check if the given username exists in the 'Users' table.
			String query = "SELECT Username FROM " + TABLE_NAME + " WHERE Username = "
					+ String.format("'%s'", Username);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and checking for username existence.
				while (resultSet.next()) {
					usernameResult = resultSet.getString("Username");
					if (Objects.equals(Username, usernameResult) == true) {
						result = usernameResult;
					} else {
						result = null;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the username if exists, otherwise null.
		return result;
	}

	// Method to check if the given username and password combination exists in the
	// 'Users' table.
	public static String passwordExists(String Username, String Password) {
		// Defining the table name in the database.
		final String TABLE_NAME = "Users";
		String result = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to check if the given username and password combination exists in
			// the 'Users' table.
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE Username = "
					+ String.format("'%s' and Password = '%s'", Username, Password);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and checking for password existence.
				while (resultSet.next()) {
					result = resultSet.getString("Password");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the password if exists, otherwise null.
		return result;
	}

	// Method to check if the given post ID exists in the 'SocialMediaPosts' table.
	public static String postidExists(String postid) {
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";
		String result = null;
		String postidResult = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to check if the given post ID exists in the 'SocialMediaPosts'
			// table.
			String query = "SELECT postid FROM " + TABLE_NAME + " WHERE postid = " + String.format("'%s'", postid);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and checking for post ID existence.

				while (resultSet.next()) {
					postidResult = resultSet.getString("postid");
					if (Objects.equals(postid, postidResult) == true) {
						result = postidResult;
					} else {
						result = null;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the post ID if exists, otherwise null.
		return result;
	}
}
