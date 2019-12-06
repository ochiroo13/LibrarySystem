package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import objects.Book;
import utils.ConnectedUser;
import utils.Const;

public class MainController implements Initializable {

	@FXML
	private Label lblWelcome;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(location);
		this.fillForm();
	}

	{
		try {
			Book.control("books.txt");
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Exception: " + e.getMessage());
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

	}

	public void logout(ActionEvent event) throws Exception {

		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

}
