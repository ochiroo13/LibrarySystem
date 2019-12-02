package view;

import java.io.IOException;
import java.net.URL;
import objects.Book;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import objects.Member;
import utils.ConnectedUser;
import utils.Const;
import utils.Database;

public class MainController implements Initializable {



	// ************************** Member tab **************************//

	@FXML
	private Label lblWelcome;

	@FXML
	private TableView COtable;

	@FXML
	private ComboBox COmember;

	@FXML
	private ComboBox CObook;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(location);
		this.fillForm();
	}

	/**
	 * fillForm
	 */
	
	{
		
		try {
			Book.control("books.txt");
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.fillForm();
		}
	
		
		
	}
	 public void fillForm() {
		 System.out.println("here");
		if (ConnectedUser.connUser.equals(null)) {
			System.out.println("Connected user is null");
		}

		String title = "";
		if (ConnectedUser.connUser.getGender().equals(Const.MALE))
			title = "Mr";
		
		else
			title = "Ms";
		lblWelcome.setText(String.format("Welcome %s. %s %s!", title, ConnectedUser.connUser.getFirstName(),
				ConnectedUser.connUser.getLastName()));
		

		// ************************** Member tab **************************//
		

		// ************************** Member tab **************************//
		

	}
	public void logout(ActionEvent event) throws Exception {
		
		 Node node=(Node) event.getSource();
      	  Stage stage=(Stage) node.getScene().getWindow();
      	
      	 FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		      Parent root = loader.load();
		     
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
}


}
