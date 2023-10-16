package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRow {
	
	public static void InsertUser (String FirstName, String LastName, String Username, String Password) {
		
		final String TABLE_NAME = "Users";

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "INSERT INTO " + TABLE_NAME + String.format(" VALUES ('%s', '%s', '%s', '%s')", 
					FirstName, LastName, Username, Password);

			int result = stmt.executeUpdate(query);

			if (result == 1) {
				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void InsertPost (Integer PostID, String Content, String Author,  Integer Likes, Integer Shares, String DateTime, String Username) {
		
		final String TABLE_NAME = "SocialMediaPosts";
		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "INSERT INTO " + TABLE_NAME + String.format(" VALUES (%s, '%s', '%s', %s, %s, '%s', '%s')", 
					PostID, Content.toString(), Author.toString(), Likes,
					Shares, DateTime.toString(), Username.toString());

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
