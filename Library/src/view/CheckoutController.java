package view;

import java.net.URL;
import java.util.ArrayList;
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
		for (int i = 0; i < Database.listBook.size(); i++) {
			listBooks.getItems().add(Database.listBook.get(i).getName());
		}
		for (int i = 0; i < Database.listMember.size(); i++) {
			listMembers.getItems().add(Database.listMember.get(i).getFirstName());
		}

		
	}
	
	public void btnCheckoutBook() {
	 	
		 if (listBooks.getSelectionModel().isEmpty()==true || listMembers.getSelectionModel().isEmpty()==true || borrowedDate.getValue().equals(null)  ) {
          return;			 
		 }
		 
       if (listBooks.getSelectionModel().isEmpty()==false && listMembers.getSelectionModel().isEmpty()==false && !borrowedDate.getValue().equals(null)  ) {
    	    for(Book b: Database.listBook ) {
    	    	if (b.getName().toString().equals(listBooks.getSelectionModel().getSelectedItem().toString() )){
    	    		Member m = new Member();
    	    		m.setFirstName(listMembers.getSelectionModel().getSelectedItem().toString());
    	    		b.setBorrower(m);
    	    		b.setBorrowerName(listMembers.getSelectionModel().getSelectedItem().toString());
    	    		b.setBorrowedDateStr(borrowedDate.getValue().toString());
    	    		System.out.println("dd");
    	    	}
    	    }
       }
       
       RefreshCOBForm();
       
	}
	

	public void RefreshCOBForm() {
		
		tblCOB.getColumns().clear();
		List<Book> tempBookList = new ArrayList<Book>();
		
		for(Book b: Database.listBook){
			if(b.getBorrower()!=null) {
				tempBookList.add(b);
			}
		}
		
		TableColumn<Book, String> colBookID = new TableColumn<Book, String>("Book ID");
		colBookID.setCellValueFactory(new PropertyValueFactory<Book, String>("id"));
		
		TableColumn<Book, String> colTitle = new TableColumn<Book, String>("Book Title");
		colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
		
		TableColumn<Book, String> colAuthor = new TableColumn<Book, String>("Book Author");
		colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("authorName"));
		
		TableColumn<Book, String> colBorrower = new TableColumn<Book, String>("Borrower");
		colBorrower.setCellValueFactory(new PropertyValueFactory<Book, String>("borrowerName"));
		
		TableColumn<Book, String> colBorDate = new TableColumn<Book, String>("Borrowed Date");
		colBorDate.setCellValueFactory(new PropertyValueFactory<Book, String>("borrowedDateStr"));
		
		ObservableList<Book> data = FXCollections.observableArrayList(tempBookList);

		tblCOB.setItems(data);

		tblCOB.getColumns().addAll(colBookID, colTitle,colAuthor, colBorrower, colBorDate);
		
		     listBooks.getItems().clear();
		for (int i = 0; i < Database.listBook.size(); i++) {
			if (Database.listBook.get(i).getBorrower()==null) {
			  listBooks.getItems().add(Database.listBook.get(i).getName());
			}
		}
	}
	
	
}
