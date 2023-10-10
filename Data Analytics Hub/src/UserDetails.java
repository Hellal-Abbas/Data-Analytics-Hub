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

}
