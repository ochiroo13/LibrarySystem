package view;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import objects.Book;
import objects.Member;
import utils.ConnectedUser;
import utils.Const;
import utils.Database;



public class CheckoutController implements Initializable {
	@FXML
	private TableView tblCOB;

	@FXML
	private ComboBox cmbMember;

	@FXML
	private ComboBox cmbBook;
	
	@FXML
	private ListView listMembers;
	
	@FXML
	private ListView listBooks;
	
	@FXML
	private DatePicker borrowedDate;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(location);
		initForm();
	}
   
	public void initForm() {
		for (int i = 0; i < Book.bookList.list.size(); i++) {
			listBooks.getItems().add(Book.bookList.list.get(i).gettittle());
		}
		for (int i = 0; i < Database.listMember.size(); i++) {
			listMembers.getItems().add(Database.listMember.get(i).getFirstName());
		}

		
	}
	
	public void btnCheckoutBook() throws ClassNotFoundException, IOException {
	 	
		 if (listBooks.getSelectionModel().isEmpty()==true || listMembers.getSelectionModel().isEmpty()==true || borrowedDate.getValue().equals(null)  ) {
          return;			 
		 }
		 
       if (listBooks.getSelectionModel().isEmpty()==false && listMembers.getSelectionModel().isEmpty()==false && !borrowedDate.getValue().equals(null)  ) {
    	    for(Book b : Book.bookList.list ) {
    	    	if (b.gettittle().toString().equals(listBooks.getSelectionModel().getSelectedItem().toString() )){
    	    		Member m = new Member();
    	    		m.setFirstName(listMembers.getSelectionModel().getSelectedItem().toString());
    	    		b.setBorrower(m);
    	    		b.setBorrowedDateStr(borrowedDate.getValue().toString());
    	    		b.setBorrowerName(listMembers.getSelectionModel().getSelectedItem().toString());
    	            b.setBorrowedDate(Date.from(borrowedDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
  	    		b.setDueDate(addMonth(b.getBorrowedDate()));

    	          System.out.println("dd");
    	    	}
    	    }
       }
       
       RefreshCOBForm();
       
	}
	
	public Date addMonth(Date date)
	{Calendar c=Calendar.getInstance();
	c.setTime(date);
	c.add(Calendar.MONTH, 1);
    return c.getTime();
		
		
		
	}

	public void RefreshCOBForm() throws ClassNotFoundException, IOException {
		
		tblCOB.getColumns().clear();
		List<Book> tempBookList = new ArrayList<Book>();
		
		for(Book b: Book.bookList.list){
			if(b.getBorrower()!=null) {
				tempBookList.add(b);
			}
		}
		
		TableColumn<Book, String> colBookID = new TableColumn<Book, String>("Book ID");
		colBookID.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
		
		TableColumn<Book, String> colTitle = new TableColumn<Book, String>("Book Title");
		colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("tittle"));
		
		TableColumn<Book, String> colAuthor = new TableColumn<Book, String>("Book Author");
		colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
		
		TableColumn<Book, String> colBorrower = new TableColumn<Book, String>("Borrower");
		colBorrower.setCellValueFactory(new PropertyValueFactory<Book, String>("borrowerName"));
		
		TableColumn<Book, String> colBorDate = new TableColumn<Book, String>("Borrowed Date");
		colBorDate.setCellValueFactory(new PropertyValueFactory<Book, String>("borrowedDateStr"));
		
		ObservableList<Book> data = FXCollections.observableArrayList(tempBookList);

		tblCOB.setItems(data);

		tblCOB.getColumns().addAll(colBookID, colTitle,colAuthor, colBorrower, colBorDate);
		Book.addBook("books.txt");
		     listBooks.getItems().clear();
		for (int i = 0; i < Book.bookList.list.size(); i++) {
			if (Book.bookList.list.get(i).getBorrower()==null) {
				
			  listBooks.getItems().add(Book.bookList.list.get(i).gettittle());
			}
			initForm();
		}
	}
	
	
}
