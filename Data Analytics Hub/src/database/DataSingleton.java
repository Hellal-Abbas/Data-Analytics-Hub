package database;

//This class provides a singleton instance to store and retrieve a user's username.
public class DataSingleton {
	// Singleton instance of the DataSingleton class, ensuring only one instance is
	// created.
	private static final DataSingleton instance = new DataSingleton();

	private String username;

	// Private constructor to prevent instantiation from outside the class.
	private DataSingleton() {
	}

	// Method to retrieve the singleton instance of the DataSingleton class.
	public static DataSingleton getInstance() {
		return instance;
	}

	// Method to get the stored username.
	public String getUsername() {
		return username;
	}

	// Method to set the username in the DataSingleton instance.
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
}
