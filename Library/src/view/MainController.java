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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
		}
		
		
	}
	public void fillForm() {

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


}
