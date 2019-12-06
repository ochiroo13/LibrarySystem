package view;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import objects.Member;
import utils.ConnectedUser;
import utils.Const;
import utils.Database;
import utils.EOperation;

public class MemberController implements Initializable {

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

	private Alert alert = new Alert(AlertType.NONE, "", ButtonType.CLOSE);

	private int currentMemberId = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(location);
		try {
			fillForm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void fillForm() throws Exception {

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

		addButtonToTable();

		gridMemberRowChangedEvent();

		tblMember.getSelectionModel().selectFirst();

		txtFirstNameMember.textProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("textfield changed from " + oldValue + " to " + newValue);
		});

	}

	private void gridMemberRowChangedEvent() {
		tblMember.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				currentMemberId = newSelection.getId();
				txtFirstNameMember.setText(newSelection.getFirstName());
				txtLastNameMember.setText(newSelection.getLastName());
				txtPhoneMember.setText(newSelection.getPhone());
				txtEmailMember.setText(newSelection.getEmail());
				if (newSelection.getBirthDate() != null) {
					datBirthDateMember.setValue(
							newSelection.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				} else {
					datBirthDateMember.setValue(null);
				}
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

		if (memberTabState.equals(Const.ADD)) {

			if (!ConnectedUser.connUser.checkPermission(EOperation.ADD_MEMBER)) {
				alert.setAlertType(AlertType.INFORMATION);
				alert.setContentText("You don't have Administrator access!");
				alert.show();
				return;
			}

			Member newMember = new Member();
			Database.maxIdMember++;
			newMember.setId(Database.maxIdMember);
			newMember.setEmail(txtEmailMember.getText());
			newMember.setPhone(txtPhoneMember.getText());
			newMember.setFirstName(txtFirstNameMember.getText());
			newMember.setLastName(txtLastNameMember.getText());
			if (datBirthDateMember.getValue() != null) {
				newMember.setBirthDate(
						Date.from(datBirthDateMember.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			} else {
				datBirthDateMember.setValue(null);
			}
			newMember.setGender(cboGenderMember.getValue());
			newMember.setCheckedOutBooks(null);
			newMember.setCreatedBy(ConnectedUser.connUser);
			newMember.setCreatedDate(new Date());
			newMember.addMember();
		} else {

			if (!ConnectedUser.connUser.checkPermission(EOperation.UPDATE_MEMBER)) {
				alert.setAlertType(AlertType.INFORMATION);
				alert.setContentText("You don't have Administrator access!");
				alert.show();
				return;
			}

			Member m = Member.getMemberById(currentMemberId);
			if (m == null) {
				alert.setAlertType(AlertType.INFORMATION);
				alert.setContentText("Member not found id: " + currentMemberId);
				alert.show();
				return;
			}
			Member newMember = new Member();
			newMember.setEmail(txtEmailMember.getText());
			newMember.setPhone(txtPhoneMember.getText());
			newMember.setFirstName(txtFirstNameMember.getText());
			newMember.setLastName(txtLastNameMember.getText());
			if (datBirthDateMember.getValue() != null) {
				newMember.setBirthDate(
						Date.from(datBirthDateMember.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			} else {
				newMember.setBirthDate(null);
			}
			newMember.setGender(cboGenderMember.getValue());
			newMember.setModifiedBy(ConnectedUser.connUser);
			newMember.setModifiedDate(new Date());
			m.updateMember(newMember);
		}

		ObservableList<Member> data = FXCollections.observableArrayList(Database.listMember);

		tblMember.setItems(data);
		tblMember.refresh();

		memberTabState = Const.NORMAL;

	}

	public void clickCancelMember(ActionEvent event) {
		memberTabState = Const.NORMAL;

		tblMember.getSelectionModel().selectFirst();
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
			clearForm();
			break;
		case Const.EDIT:
			System.out.println("EDIT");

			break;

		default:
			break;
		}
	}

	private void removeMember(int memberId) {

		if (!ConnectedUser.connUser.checkPermission(EOperation.REMOVE_MEMBER)) {
			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText("You don't have Administrator access!");
			alert.show();
			return;
		}

		Member m = Member.getMemberById(currentMemberId);
		m.removeMember();

		ObservableList<Member> data = FXCollections.observableArrayList(Database.listMember);

		tblMember.setItems(data);
		tblMember.refresh();

		memberTabState = Const.NORMAL;

		tblMember.getSelectionModel().selectFirst();
		toggleMember();
	}

	private void addButtonToTable() {
		TableColumn<Member, Void> colBtn = new TableColumn<Member, Void>();

		Callback<TableColumn<Member, Void>, TableCell<Member, Void>> cellFactory = new Callback<TableColumn<Member, Void>, TableCell<Member, Void>>() {
			@Override
			public TableCell<Member, Void> call(final TableColumn<Member, Void> param) {
				final TableCell<Member, Void> cell = new TableCell<Member, Void>() {

					private final Button btn = new Button("Delete");

					{
						btn.setOnAction((ActionEvent event) -> {
							Member data = getTableView().getItems().get(getIndex());
							removeMember(data.getId());
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};

		colBtn.setCellFactory(cellFactory);

		tblMember.getColumns().add(colBtn);

	}

	private void clearForm() {
		txtEmailMember.setText(null);
		txtPhoneMember.setText(null);
		txtFirstNameMember.setText(null);
		txtLastNameMember.setText(null);
		datBirthDateMember.setValue(null);
		cboGenderMember.setValue(null);
	}
}
