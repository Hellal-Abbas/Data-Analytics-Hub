package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//This class provides methods to insert data into specific tables ('Users' and 'SocialMediaPosts') in the database.
public class InsertRow {
	// Method to insert user details into the 'Users' table.
	public static void InsertUser(String FirstName, String LastName, String Username, String Password) {
		// Defining the table name for the 'Users' table.
		final String TABLE_NAME = "Users";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to insert user details into the 'Users' table.
			String query = "INSERT INTO " + TABLE_NAME
					+ String.format(" VALUES ('%s', '%s', '%s', '%s')", FirstName, LastName, Username, Password);
			// Executing the insert query and storing the number of rows affected.
			int result = stmt.executeUpdate(query);
			if (result == 1) {
				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Method to insert post details into the 'SocialMediaPosts' table.
	public static void InsertPost(Integer PostID, String Content, String Author, Integer Likes, Integer Shares,
			String DateTime, String Username) {
		// Defining the table name for the 'SocialMediaPosts' table.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to insert post details into the 'SocialMediaPosts' table.
			String query = "INSERT INTO " + TABLE_NAME
					+ String.format(" VALUES (%s, '%s', '%s', %s, %s, '%s', '%s')", PostID, Content.toString(),
							Author.toString(), Likes, Shares, DateTime.toString(), Username.toString());
			// Executing the insert query and storing the number of rows affected.
			int result = stmt.executeUpdate(query);
			if (result == 1) {
				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
