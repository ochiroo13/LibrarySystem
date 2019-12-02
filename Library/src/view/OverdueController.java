package view;

import java.sql.Date;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class OverdueController {
	@FXML
	private TextArea result;
	
	public void fetchBooks(){
		String overDueBooks = "";
		Date today =  new Date(System.currentTimeMillis());
		for(objects.Book b: objects.Book.bookList.list) {
			if(b.getDueDate()==null) continue;
			if(today.compareTo(b.getDueDate()) > 0)
				overDueBooks+= b.toString() + "Browwed by " + b.getBorrower() + "\n"; 
		}
		
		result.setText(overDueBooks == "" ? "No books overdued" : overDueBooks);
		
		
		
	}

}
