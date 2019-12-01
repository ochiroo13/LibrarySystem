package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utils.ConnectedUser;

public class ProfileController implements Initializable {

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

		if (ConnectedUser.connUser.equals(null)) {
			System.out.println("Connected user is null");
		}
		txtFirstName.setText(ConnectedUser.connUser.getFirstName());
		txtLastName.setText(ConnectedUser.connUser.getLastName());
		txtEmail.setText(ConnectedUser.connUser.getEmail());
		txtLoginName.setText(ConnectedUser.connUser.getLoginName());
		txtPassword.setText(ConnectedUser.connUser.getPassword());
		lblLastLoginDate.setText(ConnectedUser.connUser.getLastLoginDate().toString());

	}
}
