package manager;

import java.sql.Connection;

import jdbc.dao.CampaignUsersDao;
import jdbc.dao.UserDao;
import jdbc.dto.CampaignUsers;
import jdbc.dto.User;
import jdbc.dto.UserPk;
import jdbc.exceptions.CampaignUsersDaoException;
import jdbc.exceptions.UserDaoException;
import jdbc.factory.CampaignUsersDaoFactory;
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

	private static CampaignUsersDao campaignUsersDao = getCampaignUsersDao();

	private static UserDao getUserDao() {
		return UserDaoFactory.create(connection);
	}

	private static CampaignUsersDao getCampaignUsersDao() {
		return CampaignUsersDaoFactory.create(connection);
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
		} catch (UserDaoException u) {
			u.printStackTrace();
		}
	}

	/**
	 * Inserts a new Campaign Users register.
	 * @param accountId
	 * @param campaignId
	 */
	public static void addUserToCampaign(int accountId, int campaignId) {
		try {
			CampaignUsers campaignUser = new CampaignUsers();
			campaignUser.setCampaignId(campaignId);
			campaignUser.setUserId(accountId);
			campaignUsersDao.insert(campaignUser);
		} catch (CampaignUsersDaoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieves all campaign users registered.
	 * @param accountId
	 * @param campaignId
	 * @return
	 */
	public static CampaignUsers[] getCampaignUsers(int accountId, int campaignId) {
		Object[] sqlParams= new Object[2];
		sqlParams[0] = String.valueOf(accountId);
		sqlParams[1] = String.valueOf(campaignId);
		try {
			return campaignUsersDao.findByDynamicWhere("CAMPAIGN_ID = ? AND USER_ID = ?", sqlParams);
		} catch (CampaignUsersDaoException e) {
			e.printStackTrace();
		}
		return null;
	}
} // EOF
