package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.PostsTableModel;

public class ViewPostsQuery {

	public static ObservableList<PostsTableModel> ViewPosts(String username) {

		ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
		final String TABLE_NAME = "SocialMediaPosts";

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = " + String.format("'%s'", username);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
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

	public static String PostDetailsExport(String column, String postid) {

		final String TABLE_NAME = "SocialMediaPosts";
		String result = null;

		try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement();) {
			String query = "SELECT " + String.format("%s", column) + " FROM " + TABLE_NAME + " WHERE postid = "
					+ String.format("'%s'", postid);

			try (ResultSet resultSet = stmt.executeQuery(query)) {
				while (resultSet.next()) {
					result = resultSet.getString(String.format("%s", column));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}