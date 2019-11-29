package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.ConnectedUser;
import utils.Const;

public class MainController implements Initializable {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(location);
	}

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
		lblWelcome.setText(String.format("Welcome %s %s %s!", title, ConnectedUser.connUser.getFirstName(),
				ConnectedUser.connUser.getLastName()));

	}

}
