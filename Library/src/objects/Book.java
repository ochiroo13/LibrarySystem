package objects;

import java.util.Date;

public class Book {

	private int id;

	private String name;

	private String authorName;

	private Date publishedDate;

	private Member borrower;

	private Date borrowedDate;
	
	private String borrowedDateStr;

	private Date dueDate;

	private User addedBy;

	private Date addedDate;

	private User modifiedBy;

	private Date modifiedDate;
	
	private String borrowerName;

	public int getId() {
		return id;
	}
	
	public String getBorrowerName() {
		return borrowerName;
	}
   
	public void setBorrowedDateStr(String s) {
		borrowedDateStr=s;
	}
	
	public String getBorrowedDateStr() {
		return borrowedDateStr;
	}
	
	public void setBorrowerName(String s) {
		borrowerName=s;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
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

}
