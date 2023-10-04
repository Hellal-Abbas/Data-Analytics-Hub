import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) {
		
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); 
				Statement stmt = con.createStatement();) {
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME 
								+ "postID INT NOT NULL,"
								+ "Content VARCHAR(255) NOT NULL,"
								+ "AuthorID VARCHAR(255) NOT NULL,"
								+ "Likes INT NOT NULL,"
								+ "Shares INT NOT NULL,"
								+ "DateTime VARCHAR(255) NOT NULL,"
								+ "PRIMARY KEY (PostID))");
			
			System.out.println("Table created succesfully!");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
