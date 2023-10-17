package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

//This class provides methods to check the existence of specific tables in the database.
public class CheckTableExist {

	// Method to check the existence of the a 'Users' table in the database.
	public static boolean CheckUsers() {
		// Defining the table name to be checked.
		final String TABLE_NAME = "Users";
		Boolean status = null;

		try (Connection con = DatabaseConnection.getConnection()) {
			// Getting database metadata to check for the existence of the specified table.
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME, null);

			if (tables != null) {
				// If the table exists, set the status variable to true; otherwise, set it to
				// false.
				if (tables.next()) {
					status = true;
				} else {
					status = false;
				}
			} else {
				System.out.println("Problem with retrieving database metadata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the status indicating whether the 'Users' table exists or not.
		return status;
	}

	// Method to check the existence of the 'SocialMediaPosts' table in the
	// database.
	public static boolean CheckSocialMediaPosts() {
		// Defining the table name to be checked.
		final String TABLE_NAME = "SocialMediaPosts";
		Boolean status = null;

		try (Connection con = DatabaseConnection.getConnection()) {
			// Getting database metadata to check for the existence of the specified table.
			DatabaseMetaData dbm = con.getMetaData();
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME, null);

			if (tables != null) {
				// If the table exists, set the status variable to true; otherwise, set it to
				// false.
				if (tables.next()) {
					status = true;
				} else {
					status = false;
				}
			} else {
				System.out.println("Problem with retrieving database metadata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the status indicating whether the 'SocialMediaPosts' table exists
		// or not.
		return status;
	}
}
