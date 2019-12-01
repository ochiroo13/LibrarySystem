package utils;

import java.util.Date;

import objects.User;

public class ConnectedUser extends User {

	public static User connUser = null;

	private int ssn;

	private String firstName;

	private String lastName;

	private String email;

	private String loginName;

	private String password;

	private Date lastLoginDate;

	private boolean adminAccess;

	private boolean librarianAccess;

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

	public boolean isAdminAccess() {
		return adminAccess;
	}

	public void setAdminAccess(boolean adminAccess) {
		this.adminAccess = adminAccess;
	}

	public boolean isLibrarianAccess() {
		return librarianAccess;
	}

	public void setLibrarianAccess(boolean librarianAccess) {
		this.librarianAccess = librarianAccess;
	}

	public boolean login(String loginName, String password) {
		boolean loggedIn = false;

		for (User user : Database.listUser) {
			if (user.getLoginName().toUpperCase().equals(loginName.toUpperCase())
					&& user.getPassword().equals(password)) {
				connUser = user;
				loggedIn = true;
				break;
			}
		}

		return loggedIn;
	}
}
