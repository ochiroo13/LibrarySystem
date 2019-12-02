package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.ConnectedUser;

public class LoginController {

	@FXML
	private TextField txtUserName;

	@FXML
	private PasswordField pwdPassword;

	@FXML
	private Button btnLogin;

	@FXML
	private Label lblIncorrect;

	private Alert alert = new Alert(AlertType.NONE, "", ButtonType.CLOSE);

	public void login(ActionEvent event) throws Exception {
		ConnectedUser connUser = new ConnectedUser();
		txtUserName.setText("uuganbayar");
		pwdPassword.setText("uuganbayar");
		
	
		if (txtUserName.getText().isEmpty()) {
			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText("Login name is empty!");
			alert.show();
			return;
		} else if (pwdPassword.getText().isEmpty()) {
			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText("Password is empty!");
			alert.show();
			return;
		}
		if (connUser.login(txtUserName.getText(), pwdPassword.getText())) {
			System.out.println("success!");
			Stage primaryStage = new Stage();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));

			Parent root = (Parent) loader.load();

			MainController mainContr = loader.getController();
			mainContr.fillForm();

			Scene scene = new Scene(root, 886, 594);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			alert.setContentText("User name or password is incorrect!");
			alert.show();
		}
	}

}
