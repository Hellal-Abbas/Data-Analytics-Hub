package controller;

import java.net.URL;
import java.util.ResourceBundle;

import database.DataSingleton;
import helpers.ViewPostsQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PostsTableModel;

//This class serves as the controller for displaying posts in a table in the Data Analytics Hub application.
public class PostsTableController implements Initializable {

	private String username;

	@FXML
	private TableView<PostsTableModel> postsTable;

	@FXML
	private TableColumn<PostsTableModel, Integer> postidColumn;

	@FXML
	private TableColumn<PostsTableModel, String> contentColumn;

	@FXML
	private TableColumn<PostsTableModel, String> authorColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> likesColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> sharesColumn;

	@FXML
	private TableColumn<PostsTableModel, Integer> datetimeColumn;
	// Instance of DataSingleton for accessing user data.
	DataSingleton dataSingleton = DataSingleton.getInstance();
	// ObservableList to store posts data.
	ObservableList<PostsTableModel> Postslistview = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		// Retrieving the username of the current user from DataSingleton.
		username = dataSingleton.getUsername();
		// Setting up cell value factories to populate columns with appropriate data.
		postidColumn.setCellValueFactory(new PropertyValueFactory<>("Postid"));
		contentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
		likesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));
		sharesColumn.setCellValueFactory(new PropertyValueFactory<>("Shares"));
		datetimeColumn.setCellValueFactory(new PropertyValueFactory<>("datetime"));
		// Populating the TableView with posts data retrieved from the database using
		// ViewPostsQuery class.
		postsTable.setItems(ViewPostsQuery.ViewPosts(username));
	}
}
