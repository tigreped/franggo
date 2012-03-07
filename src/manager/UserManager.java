package manager;

import java.sql.Connection;

import jdbc.dao.UserDao;
import jdbc.dto.User;
import jdbc.dto.UserPk;
import jdbc.exceptions.UserDaoException;
import jdbc.factory.UserDaoFactory;
import jdbc.jdbc.ResourceManager;

/**
 * Manages users and its operations.
 * 
 * @author Pedro Guimarães
 * @date 06/03/2012
 *
 */
public class UserManager {

	private static Connection connection = ResourceManager.getConnection();
	
	private static UserDao userDao = getUserDao();

	private static UserDao getUserDao() {
		return UserDaoFactory.create(connection);
	}
	
	public static void addUser(String accountName) {	
		try {
			// User already exists
			if (exists(accountName))
				System.out.println("Usuário já registrado.");
			// User does not exist yet
			else {
				User user = new User();
				user.setAccountName(accountName);
				userDao.insert(user);
			}
		} catch (UserDaoException u) {
			u.printStackTrace();
		}
	}
	
	public static boolean exists(String accountName) {
		try {
			if ((userDao.findWhereAccountNameEquals(accountName)).length > 0)
				return true;
		} catch (UserDaoException u) {
			u.printStackTrace();
		}
		return false;
	}
	
	public static User[] getAllUsers() {
		try {
			return userDao.findAll();
		} catch (UserDaoException u) {
			u.printStackTrace();
			return null;
		}
	}
	
	public static User getUser(String accountName) {
		try {
			return userDao.findWhereAccountNameEquals(accountName)[0];
		} catch (UserDaoException u) {
			u.printStackTrace();
			return null;
		}
	}
	
	public static void removeUser(String accountName) {
		User user = getUser(accountName);
		try {
			userDao.delete(new UserPk(user.getId()));
		} catch(UserDaoException u) {
			u.printStackTrace();
		}
	}
	 
} //EOF
