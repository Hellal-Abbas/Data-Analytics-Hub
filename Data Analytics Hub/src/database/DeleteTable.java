package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {

	public static void deleteUsers() {
		
		final String TABLE_NAME = "Users";
		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			stmt.executeUpdate("DROP TABLE IF EXISTS " + TABLE_NAME);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void deleteSocialMediaPosts() {
		
		final String TABLE_NAME = "Users";
		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			stmt.executeUpdate("DROP TABLE IF EXISTS " + TABLE_NAME);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
