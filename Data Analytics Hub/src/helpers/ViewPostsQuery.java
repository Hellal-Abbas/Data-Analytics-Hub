package helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.PostsTableModel;

//This class contains methods for querying and retrieving posts data from the database.
public class ViewPostsQuery {
	// Method to retrieve and return a list of posts for a specific user.
	public static ObservableList<PostsTableModel> ViewPosts(String username) {
		// Creating an empty ObservableList to store posts data.
		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select posts data for the given username.
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = " + String.format("'%s'", username);
			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and adding posts data to the ObservableList.
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listview;
	}

	// Method to retrieve and return specific post details based on column name and
	// post ID.
	public static String PostDetailsExport(String column, String postid) {
		// Defining the table name in the database.
		final String TABLE_NAME = "SocialMediaPosts";
		String result = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			// SQL query to select specific column data for the given post ID.
			String query = "SELECT " + String.format("%s", column) + " FROM " + TABLE_NAME + " WHERE postid = "
					+ String.format("'%s'", postid);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				// Iterating through the result set and assigning the column data to the result
				// string.
				while (resultSet.next()) {
					result = resultSet.getString(String.format("%s", column));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Returning the retrieved specific post detail.
		return result;
	}
}
