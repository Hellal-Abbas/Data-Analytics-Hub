import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRow {
	public static void main(String[] args) {
//		final String TABLE_NAME = "Student";
		final String TABLE_NAME = "Employee";

//		try (Connection con = DatabaseConnection.getConnection();
//				Statement stmt = con.createStatement();) {
//			String query = "INSERT INTO " + TABLE_NAME +
//					" VALUES (1, 's3388490', 'Peter', 'Tilmanis')";
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
		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "INSERT INTO " + TABLE_NAME + " VALUES ('E123', 'Alex', 50000)";

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
