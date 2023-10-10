import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewPostsController implements Initializable {
	
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
	
	DataSingleton dataSingleton = DataSingleton.getInstance();
	
	ObservableList<PostsTableModel> listview = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		
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
