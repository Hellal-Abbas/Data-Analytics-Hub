import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
	public static void main(String[] args) {
		
		final String TABLE_NAME = "Employee";


		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String sql = "UPDATE " + TABLE_NAME +
					" SET salary = 1.2 * salary";

			int result = stmt.executeUpdate(sql);

			if (result == 1) {
				System.out.println("Update table " + TABLE_NAME + " executed successfully");
				System.out.println(result + " row(s) affected");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
