import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRow {
	
	public static void InsertUser (String FirstName, String LastName, String Username, String Password) {
		
		final String TABLE_NAME = "Users";

		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "INSERT INTO " + TABLE_NAME + String.format(" VALUES (%s, %s, %s, %s)", 
					FirstName.toString(), LastName.toString(), Username.toString(), Password.toString());

			int result = stmt.executeUpdate(query);

			if (result == 1) {
				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void InsertPost (Integer PostID, String Content, Integer Likes, Integer Shares, String DateTime) {
		
		final String TABLE_NAME = "SocialMediaPosts";

		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "INSERT INTO " + TABLE_NAME + String.format(" VALUES (%s, %s, %s, %s, %s)", 
					PostID.toString(), Content.toString(), Likes.toString(), Shares.toString(), DateTime.toString());

			int result = stmt.executeUpdate(query);

			if (result == 1) {
				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
//	public static void main(String[] args) {
//
//		final String TABLE_NAME = "SocialMediaPosts";
//
//	
//		try (Connection con = DatabaseConnection.getConnection();
//				Statement stmt = con.createStatement();) {
//			String query = "INSERT INTO " + TABLE_NAME + " VALUES (123456, 'Greg', 16, 3, '10/10/10 10:10')";
//
//			int result = stmt.executeUpdate(query);
//
//			if (result == 1) {
//				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
//				System.out.println(result + " row(s) affected");
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//	}
}
