package objects;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import utils.Database;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String email;

	private String phone;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String gender;

	private List<Book> checkedOutBooks;

	private User createdBy;

	private Date createdDate;

	private User modifiedBy;

	private Date modifiedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}

	public void setCheckedOutBooks(List<Book> checkedOutBooks) {
		this.checkedOutBooks = checkedOutBooks;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	@Override
	public String toString() {
		String result = "";
		result += "\n ID : " + this.id;
		result += "\n Name : " + this.firstName;
		result += "\n Email : " + this.email;
		return result;
	}

	public void addMember() {
		Database.listMember.add(this);
	}

	public void updateMember(Member newMember) {
		setEmail(newMember.getEmail());
		setPhone(newMember.getPhone());
		setFirstName(newMember.getFirstName());
		setLastName(newMember.getLastName());
		setBirthDate(newMember.getBirthDate());
		setGender(newMember.getGender());
	}

	public void removeMember() {
		Database.listMember.remove(this);
	}

	public static Member getMemberById(int id) {
		Member member = null;
		for (Member m : Database.listMember) {
			if (m.getId() == id) {
				member = m;
			}
		}

		return member;
	}

}
