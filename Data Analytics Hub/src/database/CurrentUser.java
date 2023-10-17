package database;

//This class is a generic class, allowing storage of any user object type.
public class CurrentUser<User> {

	private User user;
	// Singleton instance of the CurrentUser class, ensuring only one instance is
	// created.
	private final static CurrentUser INSTANCE = new CurrentUser();

	// Private constructor to prevent instantiation from outside the class.
	private CurrentUser() {
	}

	// Method to retrieve the singleton instance of the CurrentUser class.
	public static CurrentUser getInstance() {
		return INSTANCE;
	}

	// Method to set the user object in the CurrentUser instance.
	public void setUser(User u) {
		this.user = u;
	}

	// Method to get the user object stored in the CurrentUser instance.
	public User getUser() {
		return this.user;
	}
}
