package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//This class provides methods to update data in specific tables in the database.
public class UpdateTable {

	// Method to update user details in the 'Users' table.
	public static int UpdateUserDetails(String column, String newvalue, String username) {
		// Defining the table name in the database.
		final String TABLE_NAME = "Users";
		int result = 0;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to update a specific column with a new value for a given username
			// in the 'Users' table.
			String sql = "UPDATE " + TABLE_NAME + " SET " + column + " = " + String.format("'%s'", newvalue)
					+ " WHERE username = " + String.format("'%s'", username);
			// Executing the update query and storing the number of rows affected.
			result = stmt.executeUpdate(sql);
			if (result == 1) {
				System.out.println("Value updated successfully");
				System.out.println(result + " row(s) affected");
			} else {
				System.out.println(result);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the number of rows affected by the update operation.
		return result;
	}

	// Method to update the 'username' field in the 'SocialMediaPosts' table.
	public static int UpdatePostsUsername(String column, String newvalue, String username) {
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";
		int result = 0;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to update a specific column with a new value for a given username
			// in the 'SocialMediaPosts' table.
			String sql = "UPDATE " + TABLE_NAME + " SET " + column + " = " + String.format("'%s'", newvalue)
					+ " WHERE username = " + String.format("'%s'", username);
			// Executing the update query and storing the number of rows affected.
			result = stmt.executeUpdate(sql);
			System.out.println("Value updated successfully");
			System.out.println(result + " row(s) affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the number of rows affected by the update operation.
		return result;
	}
}
