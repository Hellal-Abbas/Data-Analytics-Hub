import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckTableExist {
	
	public static boolean CheckUsers() {
		
		final String TABLE_NAME = "Users";
		
		Boolean status = null;

		
		try (Connection con = DatabaseConnection.getConnection()) {

			DatabaseMetaData dbm = con.getMetaData();
			
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME, null);
			
				
			if(tables != null) {
				if (tables.next()) {
					status = true;
				}
				else {
					status = false;
				}
			} else {
				System.out.println("Problem with retrieving database metadata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return status;
		
	}
	
	
	public static boolean CheckSocialMediaPosts() {
		
		final String TABLE_NAME = "SocialMediaPosts";
		
		Boolean status = null;

		
		try (Connection con = DatabaseConnection.getConnection()) {

			DatabaseMetaData dbm = con.getMetaData();
			
			ResultSet tables = dbm.getTables(null, null, TABLE_NAME, null);
			
				
			if(tables != null) {
				if (tables.next()) {
					status = true;
				}
				else {
					status = false;
				}
			} else {
				System.out.println("Problem with retrieving database metadata");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return status;
		
	}
	
	
}
