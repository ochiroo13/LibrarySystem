package view;

import objects.Book;
import objects.BookLog;
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
    ListView<String> authorList ;
    @FXML
    TextField authorName ;
    @FXML
    TextField authorSurname ;
    @FXML
    Label tittle,numberOfPages,category,name,surname,publishedYear,authors ;
    List< Control> control = new ArrayList<>();
    List<Author> list = new ArrayList<>();

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {

        this.control.add( bookTittle) ;
        this.control.add( bookCategory);
        this.control.add(bookNum);
        this.control.add( authorList);
        this.control.add( bookRyear);
        


    }
    
  class Clear implements Consumer<Control>{

	@Override
	public void accept(Control arg0) {
		if(arg0 instanceof TextField) ((TextField) arg0).setText("");
		else if(arg0 instanceof ListView) ((ListView) arg0).getItems().clear();
		else   ((DatePicker)arg0).setValue(null);
		
	}
	  
	  
	  
  } 

    public void control( )
    {   Consumer < Control> action = new Clear(); 
                         
    	control.forEach(action);
    	this.list.clear();
    	
    	
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
         Book.bookList.list.add(book);
    	
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
     	control();
    	
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
    
    @FXML
    public void deleteAuthor(ActionEvent event)
    
    {   
    	list.remove(authorList.getSelectionModel().getSelectedIndex());
    	authorList.getItems().remove(authorList.getSelectionModel().getSelectedIndex());
    	
    }
}
