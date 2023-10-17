package helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;

//This class contains methods for retrieving user and post details from the database.
public class UserDetails {

	// Method to retrieve specific user details based on the provided username and
	// column name.
	public static String getUserDetails(String username, String UserInformation) {
		// Defining the table name in the database.
		final String TABLE_NAME = "Users";
		String userInfo = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select specific user information for the given username.
			String query = "SELECT " + UserInformation + " FROM " + TABLE_NAME + " WHERE Username = "
					+ String.format("'%s'", username);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and assigning user information to the
				// userInfo string.
				while (resultSet.next()) {
					userInfo = resultSet.getString(UserInformation);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the retrieved user information.
		return userInfo;
	}

	// Method to retrieve specific post details based on the provided username, post
	// ID, and column name.
	public static String getPost(String username, String postid, String UserInformation) {
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";
		String postInfo = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select specific post information for the given username, post
			// ID, and column name.
			String query = "SELECT " + UserInformation + " FROM " + TABLE_NAME + " WHERE Username = "
					+ String.format("'%s'", username) + " and postid = " + String.format("'%s'", postid);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and assigning post information to the
				// postInfo string.
				while (resultSet.next()) {
					postInfo = resultSet.getString(UserInformation);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the retrieved post information.
		return postInfo;
	}
}
