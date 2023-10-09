import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBatch {

	public static void main(String[] args) {
		
		final String TABLE_NAME = "Employee";
		
		String query = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ?);";
		
		String[] employee_number = new String[] {"E123", "E345"};
		String[] name = new String[] {"Alex", "Lucy"};
		float[] salary = new float[] {50000, 60000};
		
		try (Connection connection = DatabaseConnection.getConnection();
				
				PreparedStatement prepareStmt = connection.prepareStatement(query)) {
			
			for (int i = 0; i < employee_number.length; i++) {
				
				prepareStmt.setString(1, employee_number[i]);
				prepareStmt.setString(2, name[i]);
				prepareStmt.setFloat(3, salary[i]);
				prepareStmt.addBatch();
			}
			prepareStmt.executeBatch();
			System.out.println("Insert all records successfully");
				} catch (SQLException e) {
					e.printStackTrace();
					
				}


	}

}
