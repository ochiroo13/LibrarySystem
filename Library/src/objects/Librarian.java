package objects;

import java.util.Date;

public class Librarian extends User {

	private int ssn;

	private String firstName;

	private String lastName;

	private String email;

	private String loginName;

	private String password;

	private Date lastLoginDate;

	private boolean canAddMember;

	private boolean canAddBook;

	private String gender;

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public boolean isCanAddMember() {
		return canAddMember;
	}

	public void setCanAddMember(boolean canAddMember) {
		this.canAddMember = canAddMember;
	}

	public boolean isCanAddBook() {
		return canAddBook;
	}

	public void setCanAddBook(boolean canAddBook) {
		this.canAddBook = canAddBook;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
