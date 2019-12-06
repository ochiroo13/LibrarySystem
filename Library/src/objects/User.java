package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.EOperation;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ssn;

	private String firstName;

	private String lastName;

	private String email;

	private String loginName;

	private String password;

	private Date lastLoginDate;

	private String gender;

	private List<Role> lstRoles;

	private String pictureUrl;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public List<Role> getLstRoles() {
		return lstRoles;
	}

	public void setLstRoles(List<Role> lstRoles) {
		this.lstRoles = lstRoles;
	}

	public void addRole(Role role) {
		if (this.lstRoles == null)
			this.lstRoles = new ArrayList<Role>();

		this.lstRoles.add(role);
	}

	public boolean checkPermission(EOperation oper) {
		boolean result = false;
		for (Role role : this.lstRoles) {

			switch (oper) {
			case ADD_MEMBER:
				result = role.isCanAddMember();
				break;
			case UPDATE_MEMBER:
				result = role.isCanAddMember();
				break;
			case REMOVE_MEMBER:
				result = role.isCanAddMember();
				break;

			default:
				break;
			}
			if (result)
				break;
		}
		return result;
	}
}
