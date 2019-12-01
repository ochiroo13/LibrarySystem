package view;

import objects.Book;
import objects.BookLog;
import objects.User;
import utils.ConnectedUser;

import java.io.IOException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    ListView authorList ;
    @FXML
    TextField authorName ;
    @FXML
    TextField authorSurname ;

   List<Author> list = new ArrayList<>();

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {

        // do initialization and configuration work...

        // trivial example, could also be done directly in the fxml:
       
    }
    @FXML
	public void addBook(ActionEvent event) throws ClassNotFoundException
	{
    	Book book = new Book(Book.bookList.list.size(), 
    			bookTittle.getText(),
    			Integer.parseInt(bookNum.getText()),
    			Date.from(bookRyear.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
    			bookCategory.getText(),
    			ConnectedUser.connUser, 
    			Calendar.getInstance().getTime(), 
    			list);
    	
    	
     	try {
			book.addBook("books.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
     	try {
			Book.readBooks("books.txt");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    
    @FXML
   	public void addAuthor(ActionEvent event)
   	{
   		Author auth = new Author(authorName.getText(), authorSurname.getText());
   		
		authorList.getItems().add(authorName.getText()+"  "+ authorSurname.getText());
		authorName.setText("");
		authorSurname.setText("");
		list.add(auth);



   	}
}
