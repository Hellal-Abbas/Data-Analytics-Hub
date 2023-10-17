package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//This class provides methods to create specific tables ('Users' and 'SocialMediaPosts') in the database.
public class CreateTable {
	// Method to create the 'Users' table in the database.
	public static void UsersTable() {
		// Defining the table name for the 'Users' table.
		final String TABLE_NAME = "Users";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to create the 'Users' table with specified columns and primary key
			// constraint.
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(Firstname VARCHAR(255) NOT NULL,"
					+ "Lastname VARCHAR(255) NOT NULL," + "Username VARCHAR(255) NOT NULL,"
					+ "Password VARCHAR(255) NOT NULL," + "PRIMARY KEY (Username))");

			System.out.println("Table created succesfully!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Method to create the 'SocialMediaPosts' table in the database.
	public static void SocialMediaPostsTable() {
		// Defining the table name for the 'SocialMediaPosts' table.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to create the 'SocialMediaPosts' table with specified columns and
			// primary key constraint.
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(postID INT NOT NULL,"
					+ "Content VARCHAR(255) NOT NULL," + "Author VARCHAR(255) NOT NULL," + "Likes INT NOT NULL,"
					+ "Shares INT NOT NULL," + "DateTime VARCHAR(255) NOT NULL," + "Username VARCHAR(255) NOT NULL,"
					+ "PRIMARY KEY (PostID))");

			System.out.println("Table created succesfully!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
