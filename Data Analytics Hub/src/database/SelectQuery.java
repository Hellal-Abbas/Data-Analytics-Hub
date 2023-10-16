package database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
	public static void main(String[] args) {
		
		final String TABLE_NAME = "Employee";
		
		try (Connection con = DatabaseConnection.getConnection();
				Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while(resultSet.next()) {
					System.out.printf("Employee Number: %s | Name: %s | Salary: %f\n", 
							resultSet.getString("employee_number"), resultSet.getString("name"), resultSet.getFloat("salary"));
				}
			} 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
