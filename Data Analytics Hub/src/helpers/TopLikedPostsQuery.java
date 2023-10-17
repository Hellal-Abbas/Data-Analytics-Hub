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

public class TopLikedPostsQuery {

	public static ObservableList<AllUsersModel> AllUsers(String username) {

		ObservableList<AllUsersModel> listview = FXCollections.observableArrayList();
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT DISTINCT username FROM " + TABLE_NAME;

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while (resultSet.next()) {
					listview.add(new AllUsersModel(resultSet.getString("username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listview;
	}

	public static ObservableList<PostsTableModel> AllPosts(String username) {

		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY Likes DESC";

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listview;
	}

	public static ObservableList<PostsTableModel> NumOfPosts(int numOfPosts) {

		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY Likes DESC" + " LIMIT "
					+ String.format("%s", numOfPosts);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listview;
	}

	public static ObservableList<PostsTableModel> Usernameonly(String username) {

		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = " + String.format("'%s'", username)
					+ " ORDER BY Likes DESC";

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listview;
	}

	public static ObservableList<PostsTableModel> NumOfPostsWithUsername(String username, int numOfPosts) {

		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = " + String.format("'%s'", username)
					+ " ORDER BY Likes DESC" + " LIMIT " + String.format("%s", numOfPosts);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while (resultSet.next()) {
					listview.add(new PostsTableModel(resultSet.getInt("postID"), resultSet.getString("Content"),
							resultSet.getString("Author"), resultSet.getInt("Likes"), resultSet.getInt("Shares"),
							resultSet.getString("DateTime"), resultSet.getString("Username")));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listview;
	}
}
