package utils;

import java.io.Serializable;
import java.util.Date;

import objects.User;

public final class ConnectedUser implements Serializable {
	private static final long serialVersionUID = 1L;

	public static User connUser = null;

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
