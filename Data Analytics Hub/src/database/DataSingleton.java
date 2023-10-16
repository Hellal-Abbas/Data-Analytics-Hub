package database;

public class DataSingleton {
	
	private static final DataSingleton instance = new DataSingleton();
	
	private String username;
	
	private DataSingleton() {}

	public static DataSingleton getInstance() {
		return instance;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}


}
	


