package view;

import java.net.URL;
import java.time.ZoneId;
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
	
	@FXML
	private TableView COtable;
	
	@FXML
	private ComboBox COmember;
	
	@FXML
	private ComboBOx CObook;
	
	
	// ************************** Profile tab **************************//

	// ************************** Member tab **************************//
	@FXML
	private TableView<Member> tblMember;

	@FXML
	private TextField txtFirstNameMember;

	@FXML
	private TextField txtLastNameMember;

	@FXML
	private TextField txtPhoneMember;

	@FXML
	private TextField txtEmailMember;

	@FXML
	private DatePicker datBirthDateMember;

	@FXML
	private ComboBox<String> cboGenderMember;

	@FXML
	private Button btnAddMember;

	@FXML
	private Button btnSaveMember;

	@FXML
	private Button btnCancelMember;

	private String memberTabState = Const.NORMAL;

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

		// Gender combo
		cboGenderMember.getItems().addAll(Const.MALE, Const.FEMALE);

		TableColumn<Member, String> memberId = new TableColumn<Member, String>("Id");
		memberId.setCellValueFactory(new PropertyValueFactory<Member, String>("Id"));
		memberId.setVisible(true);

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

		tblMember.getColumns().addAll(memberId, firstNameCol, emailCol, genderCol, phoneCol);

		gridMemberRowChangedEvent();

		tblMember.getSelectionModel().selectFirst();

		txtFirstNameMember.textProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("textfield changed from " + oldValue + " to " + newValue);
		});
	}

	private void gridMemberRowChangedEvent() {
		tblMember.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				txtFirstNameMember.setText(newSelection.getFirstName());
				txtLastNameMember.setText(newSelection.getLastName());
				txtPhoneMember.setText(newSelection.getPhone());
				txtEmailMember.setText(newSelection.getEmail());
				datBirthDateMember
						.setValue(newSelection.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				cboGenderMember.setValue(newSelection.getGender());
			}
		});
	}

	public void clickAddMember(ActionEvent event) {
		memberTabState = Const.ADD;
		toggleMember();
		System.out.println("clickAddMember");
	}

	public void clickSaveMember(ActionEvent event) {
		memberTabState = Const.NORMAL;

		toggleMember();
		System.out.println("clickSaveMember");

	}

	public void clickCancelMember(ActionEvent event) {
		memberTabState = Const.NORMAL;

		toggleMember();
		System.out.println("clickCancelMember");

	}

	public void textChangedMember(ActionEvent event) {

		System.out.println("textChangedMember");
	}

	private void toggleMember() {

		switch (memberTabState) {
		case Const.NORMAL:
			System.out.println("NORMAL");

			break;
		case Const.ADD:
			System.out.println("ADD");

			break;
		case Const.EDIT:
			System.out.println("EDIT");

			break;

		default:
			break;
		}
	}

}
