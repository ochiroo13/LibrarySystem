package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

	// ************************** Profile tab **************************//
	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtLoginName;

	@FXML
	private TextField txtPassword;

	@FXML
	private Label lblLastLoginDate;

	@FXML
	private Label lblWelcome;
	// ************************** Profile tab **************************//

	// ************************** Member tab **************************//
	@FXML
	private TableView<Member> tblMember;

	// ************************** Member tab **************************//

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(location);
	}

	/**
	 * fillForm
	 */
	public void fillForm() {

		if (ConnectedUser.connUser.equals(null)) {
			System.out.println("Connected user is null");
		}
		txtFirstName.setText(ConnectedUser.connUser.getFirstName());
		txtLastName.setText(ConnectedUser.connUser.getLastName());
		txtEmail.setText(ConnectedUser.connUser.getEmail());
		txtLoginName.setText(ConnectedUser.connUser.getLoginName());
		txtPassword.setText(ConnectedUser.connUser.getPassword());
		lblLastLoginDate.setText(ConnectedUser.connUser.getLastLoginDate().toString());

		String title = "";
		if (ConnectedUser.connUser.getGender().equals(Const.MALE))
			title = "Mr";
		else
			title = "Ms";
		lblWelcome.setText(String.format("Welcome %s. %s %s!", title, ConnectedUser.connUser.getFirstName(),
				ConnectedUser.connUser.getLastName()));

		//////////////////////////////////////////////////////////////

		TableColumn<Member, String> firstNameCol = new TableColumn<Member, String>("Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));

		TableColumn<Member, String> emailCol = new TableColumn<Member, String>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<Member, String>("email"));

		TableColumn<Member, String> genderCol = new TableColumn<Member, String>("Gender");
		genderCol.setCellValueFactory(new PropertyValueFactory<Member, String>("gender"));

		TableColumn<Member, String> phoneCol = new TableColumn<Member, String>("Phone");
		phoneCol.setCellValueFactory(new PropertyValueFactory<Member, String>("phone"));

		ObservableList<Member> data = FXCollections.observableArrayList(Database.listMember);

		tblMember.setItems(data);

		tblMember.getColumns().addAll(firstNameCol, emailCol, genderCol, phoneCol);

//		for (Member member : Database.listMember) {
//			tblMember.getItems().add(member);
//		}
	}

}
