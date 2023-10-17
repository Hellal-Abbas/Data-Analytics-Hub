package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {

	public static int UpdateUserDetails(String column, String newvalue, String username) {

		final String TABLE_NAME = "Users";
		int result = 0;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + column + " = " + String.format("'%s'", newvalue)
					+ " WHERE username = " + String.format("'%s'", username);

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
		return result;
	}

	public static int UpdatePostsUsername(String column, String newvalue, String username) {

		final String TABLE_NAME = "SocialMediaPosts";
		int result = 0;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + column + " = " + String.format("'%s'", newvalue)
					+ " WHERE username = " + String.format("'%s'", username);

			result = stmt.executeUpdate(sql);
			System.out.println("Value updated successfully");
			System.out.println(result + " row(s) affected");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
