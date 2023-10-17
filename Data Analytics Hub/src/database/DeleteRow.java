package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//This class provides a method to remove a row from the 'SocialMediaPosts' table in the database.
public class DeleteRow {
	// Method to remove a post from the 'SocialMediaPosts' table based on the
	// provided post ID.
	public static void removePost(String postid) {
		// Defining the table name for the 'SocialMediaPosts' table.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to delete a row from the 'SocialMediaPosts' table based on the
			// provided post ID.
			String sql = "DELETE FROM " + TABLE_NAME + " WHERE postid = " + String.format("'%s'", postid);
			// Executing the delete query and storing the number of rows affected.
			int result = stmt.executeUpdate(sql);

			if (result == 1) {
				System.out.println("Delete from table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
