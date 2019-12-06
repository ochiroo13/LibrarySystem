package view;

import objects.Book;
import objects.BookLog;
import objects.InputException;
import objects.User;
import utils.ConnectedUser;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import objects.Author;

public class AddBookController {

	@FXML
	TextField bookTittle;
	@FXML
	TextField bookNum;
	@FXML
	TextField bookCategory;
	@FXML
	DatePicker bookRyear;
	@FXML
	ListView<String> authorList;
	@FXML
	TextField authorName;
	@FXML
	TextField authorSurname;
	@FXML
	Label tittle, numberOfPages, category, name, surname, publishedYear, authors;
	List<Author> list = new ArrayList<>();
	HashMap<Label, Control> control = new HashMap<Label, Control>();

	// called by the FXML loader after the labels declared above are injected:
	public void initialize() {

		this.control.put(tittle, bookTittle);
		this.control.put(category, bookCategory);
		this.control.put(numberOfPages, bookNum);
		this.control.put(authors, authorList);
		this.control.put(publishedYear, bookRyear);

	}

	class Clear implements BiConsumer<Label, Control> {

		@Override
		public void accept(Label label, Control control) {
			label.setTextFill(Color.web("#13a6ff"));

			if (control instanceof TextField)
				((TextField) control).setText("");
			else if (control instanceof ListView)
				((ListView) control).getItems().clear();
			else
				((DatePicker) control).setValue(null);

		}

	}

	public void control() {
		BiConsumer<Label, Control> action = new Clear();

		control.forEach(action);
		this.list.clear();

	}

	public void addControl() throws Exception {
		String error = "";
		if (bookTittle.getText().isEmpty()) {
			error += "* empty tittle \n";
			tittle.setTextFill(Color.web("#ff0000"));
		} else
			tittle.setTextFill(Color.web("#13a6ff"));
		try {

			Integer.parseInt(bookNum.getText());
			numberOfPages.setTextFill(Color.web("#13a6ff"));
		}

		catch (Exception e) {
			numberOfPages.setTextFill(Color.web("#ff0000"));
			error += "* invalid number of pages\\n";
		}
		if (bookCategory.getText().isEmpty()) {
			error += "* empty category \n";
			category.setTextFill(Color.web("#ff0000"));
		} else
			category.setTextFill(Color.web("#13a6ff"));

		try {

			Date.from(bookRyear.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

			publishedYear.setTextFill(Color.web("#13a6ff"));
		} catch (Exception e) {
			publishedYear.setTextFill(Color.web("#ff0000"));
			error += "* invalid number of pages";
		}

		;
		if (!error.isEmpty())
			throw new InputException(error);

	}

	@FXML
	public void addBook(ActionEvent event) throws Exception {

		try {
			this.addControl();

			Book.bookList.list
					.add(new Book(Book.bookList.list.size(), bookTittle.getText(), Integer.parseInt(bookNum.getText()),
							Date.from(bookRyear.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
							bookCategory.getText(), ConnectedUser.connUser, Calendar.getInstance().getTime(), list));

			Book.addBook("books.txt");
			this.control();

		} catch (InputException e) {

		}

	}

	@FXML
	public void addAuthor(ActionEvent event) {
		Author auth = new Author(authorName.getText(), authorSurname.getText());

		authorList.getItems().add(authorName.getText() + "  " + authorSurname.getText());
		authorName.setText("");
		authorSurname.setText("");
		list.add(auth);

	}

	@FXML
	public void deleteAuthor(ActionEvent event)

	{
		list.remove(authorList.getSelectionModel().getSelectedIndex());
		authorList.getItems().remove(authorList.getSelectionModel().getSelectedIndex());

	}
}
