package helpers;
import database.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetails {
	
	public static String getUserDetails(String username, String UserInformation) {
		
		final String TABLE_NAME = "Users";
		String userInfo = null;

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			
			
			String query = "SELECT " + UserInformation + " FROM " + TABLE_NAME + " WHERE Username = " +
					String.format("'%s'", username);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while(resultSet.next()) {
					userInfo = resultSet.getString(UserInformation);
				}
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return userInfo;
	}

	public static String getPost(String username, String postid, String UserInformation) {
		
		final String TABLE_NAME = "SocialMediaPosts";
		String postInfo = null;

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			
			
			String query = "SELECT " + UserInformation + " FROM " + TABLE_NAME + " WHERE Username = " +
					String.format("'%s'", username) + " and postid = " + String.format("'%s'", postid);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while(resultSet.next()) {
					postInfo = resultSet.getString(UserInformation);
				}
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return postInfo;
	}
}
