package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import objects.Book;

public class BookLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
    public List<Book> list = new ArrayList<Book>();
     

}
