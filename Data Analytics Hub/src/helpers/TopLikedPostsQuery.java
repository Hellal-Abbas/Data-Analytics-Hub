package helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.AllUsersModel;
import model.PostsTableModel;

//This class provides methods for querying and retrieving top liked posts and user data from the database.
public class TopLikedPostsQuery {

	// Method to retrieve usernames of all users who have posted.
	public static ObservableList<AllUsersModel> AllUsers(String username) {
		// Creating an empty ObservableList to store usernames.
		ObservableList<AllUsersModel> listview = FXCollections.observableArrayList();
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select distinct usernames from the 'SocialMediaPosts' table.
			String query = "SELECT DISTINCT username FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and adding usernames to the ObservableList.
				while (resultSet.next()) {
					listview.add(new AllUsersModel(resultSet.getString("username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the populated ObservableList of usernames.
		return listview;
	}

	// Method to retrieve all posts sorted by the number of likes in descending
	// order.
	public static ObservableList<PostsTableModel> AllPosts(String username) {
		// Creating an empty ObservableList to store posts data.
		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select all posts and order them by the number of likes in
			// descending order.
			String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY Likes DESC";

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and adding posts data to the ObservableList.
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the populated ObservableList of posts data.
		return listview;
	}

	// Method to retrieve a specific number of top liked posts.
	public static ObservableList<PostsTableModel> NumOfPosts(int numOfPosts) {
		// Creating an empty ObservableList to store posts data.
		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select a specific number of top liked posts and order them by
			// the number of likes in descending order.
			String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY Likes DESC" + " LIMIT "
					+ String.format("%s", numOfPosts);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and adding posts data to the ObservableList.
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the populated ObservableList of posts data.
		return listview;
	}

	// Method to retrieve top liked posts posted by a specific user.
	public static ObservableList<PostsTableModel> Usernameonly(String username) {
		// Creating an empty ObservableList to store posts data.
		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select top liked posts by a specific user and order them by the
			// number of likes in descending order.
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = " + String.format("'%s'", username)
					+ " ORDER BY Likes DESC";

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and adding posts data to the ObservableList.
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the populated ObservableList of posts data.
		return listview;
	}

	// Method to retrieve a specific number of top liked posts posted by a specific
	// user.
	public static ObservableList<PostsTableModel> NumOfPostsWithUsername(String username, int numOfPosts) {
		// Creating an empty ObservableList to store posts data.
		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select a specific number of top liked posts by a specific user
			// and order them by the number of likes in descending order.
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = " + String.format("'%s'", username)
					+ " ORDER BY Likes DESC" + " LIMIT " + String.format("%s", numOfPosts);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and adding posts data to the ObservableList.
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the populated ObservableList of posts data.
		return listview;
	}
}
