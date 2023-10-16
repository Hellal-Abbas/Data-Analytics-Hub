package controller;

import java.io.IOException;

import database.DataSingleton;
import database.ViewPostsQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PostsTableModel;

public class TopLikedPostsController {

	private String username;

	@FXML
	private TextField nPostsDisplayField;

	@FXML
	private TextField filterByUsernameField;

	@FXML
	private TableView userTable;

	@FXML
	private TableColumn users;

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

	DataSingleton dataSingleton = DataSingleton.getInstance();

	ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();

	@FXML
	public void submitHandler(ActionEvent event) throws IOException {

		username = dataSingleton.getUsername();

		postidColumn.setCellValueFactory(new PropertyValueFactory<>("Postid"));
		contentColumn.setCellValueFactory(new PropertyValueFactory<>("Content"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
		likesColumn.setCellValueFactory(new PropertyValueFactory<>("Likes"));
		sharesColumn.setCellValueFactory(new PropertyValueFactory<>("Shares"));
		datetimeColumn.setCellValueFactory(new PropertyValueFactory<>("datetime"));

		postsTable.setItems(ViewPostsQuery.ViewPosts(username));

	}

}
