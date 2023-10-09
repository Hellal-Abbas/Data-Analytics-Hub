import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class DataExists {
	
	public static String usernameExists (String Username) {
		
		final String TABLE_NAME = "Users";
		String result = null;
		String usernameResult = null;

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			
			
			String query = "SELECT Username FROM " + TABLE_NAME + " WHERE Username = " +
					String.format("'%s'", Username);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while(resultSet.next()) {
					usernameResult = resultSet.getString("Username");
					
					if (Objects.equals(Username, usernameResult) == true) {
						result = usernameResult;	
					} else {
						result = null;
					}
				}
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	
	public static String passwordExists (String Username, String Password) {
		
		final String TABLE_NAME = "Users";
		String result = null;

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			
			
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE Username = " +
					String.format("'%s' and Password = '%s'", Username, Password);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while(resultSet.next()) {
					result = resultSet.getString("Password");
				}
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}

}
