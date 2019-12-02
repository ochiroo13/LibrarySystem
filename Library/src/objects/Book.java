package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements Serializable {

	private int id;

	private static final long serialVersionUID = 1L;

	public static BookLog bookList = new BookLog();

	private String tittle;

	private int numPage;

	private Date releaseYear;

	private String category;

	private Member borrower;

	private Date borrowedDate;

	private String borrowedDateStr;

	private Date dueDate;

	private User addedBy;

	private Date addedDate;

	private User modifiedBy;

	private Date modifiedDate;

	private List<Author> authors = new ArrayList<>();
	private String borrowerName;

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowedDateStr(String s) {
		borrowedDateStr = s;
	}

	public String getBorrowedDateStr() {
		return borrowedDateStr;
	}

	public void setBorrowerName(String s) {
		borrowerName = s;
	}

	public Book(int id, String tittle, int numPage, Date releaseYear, String category, User addedBy, Date addedDate,
			List<Author> authors) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.numPage = numPage;
		this.releaseYear = releaseYear;
		this.category = category;
		this.addedBy = addedBy;
		this.addedDate = addedDate;
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Member getBorrower() {
		return borrower;
	}

	public void setBorrower(Member borrower) {
		this.borrower = borrower;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String gettittle() {
		return tittle;
	}

	public void settittle(String tittle) {
		this.tittle = tittle;
	}

	public int getNumPage() {
		return numPage;
	}

	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		String result = "";
		result += " ID : " + this.id;
		result += "\n Tittle : " + this.tittle;
		result += "\n Authors : ";
		for (Author auth : this.authors)
			result += "\n + " + auth.getName() + " " + auth.getSurname();
		result += "\n Number of Pages : " + this.numPage;
		result += "\n Release year : " + this.releaseYear;
		result += "\n Category : " + this.category;

		return result;
	}

	public static void control(String filename) throws ClassNotFoundException, IOException {

		File file = new File(filename);

		if (file.length() > 0)
			readBooks(filename);

	}

	public void addBook(String filename) throws IOException, ClassNotFoundException {
		control(filename);
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);
		bookList.list.add(this);

		out.writeObject(bookList);
		out.close();
		file.close();

	}

	public static void readBooks(String filename) throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fileIn);

		BookLog book = (BookLog) in.readObject();
		Book.bookList.list = book.list;

		for (Book bk : book.list)
			System.out.println(bk);

		System.out.println(book.list.size());
		in.close();
		fileIn.close();

	}

}
