import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataExists {
	
	public static int UserExists (String Username) {
		
		final String TABLE_NAME = "Users";
		int result = 1;

		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			
			
			String query = "SELECT Username FROM " + TABLE_NAME + " WHERE Username = " +
					String.format("'%s'", Username);

			int result = stmt.executeUpdate(query);

			if (result == 1) {
				System.out.println("Insert into table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
		
	}

}
