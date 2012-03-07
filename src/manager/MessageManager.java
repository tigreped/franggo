package manager;

import java.sql.Connection;

import jdbc.dao.MessageDao;
import jdbc.dao.SentMessagesDao;
import jdbc.dto.Campaign;
import jdbc.dto.Message;
import jdbc.dto.MessagePk;
import jdbc.dto.SentMessages;
import jdbc.dto.User;
import jdbc.exceptions.MessageDaoException;
import jdbc.exceptions.SentMessagesDaoException;
import jdbc.factory.MessageDaoFactory;
import jdbc.factory.SentMessagesDaoFactory;
import jdbc.jdbc.ResourceManager;

public class MessageManager {

	private static Connection connection = ResourceManager.getConnection();

	private static MessageDao messageDao = MessageDaoFactory.create(connection);

	private static SentMessagesDao sentMessagesDao = SentMessagesDaoFactory
			.create(connection);

	/**
	 * Add a new message to a campaign;
	 * 
	 * @param message
	 *            the message text
	 * @param userId
	 *            the user who created the message
	 * @param campaignId
	 *            the campaign id wich the message belongs to;
	 */
	public static void addMessage(String message, int userId, int campaignId) {
		Message msg = new Message();
		msg.setMessage(message);
		msg.setUserId(userId);
		msg.setUserIdNull(false);
		msg.setCampaignId(campaignId);
		msg.setCampaignIdNull(false);
		try {
			messageDao.insert(msg);
		} catch (MessageDaoException m) {
			m.printStackTrace();
		}
	}

	/**
	 * Removes a message from a campaign.
	 * 
	 * @param messageId
	 */
	public static void removeMessage(int messageId) {
		try {
			messageDao.delete(new MessagePk(messageId));
		} catch (MessageDaoException m) {
			m.printStackTrace();
		}
	}

	/**
	 * Gets all messages from one campaign.
	 */
	public static Message[] getMessagesByCampaign(String name) {
		Campaign campaign = CampaignManager.getCampaignByName(name);
		Message[] messages = null;
		try {
			messages = messageDao.findWhereCampaignIdEquals(campaign.getId());
		} catch (MessageDaoException e) {
			e.printStackTrace();
		}
		if (messages.length > 0)
			return messages;
		return null;
	}

	/**
	 * Gets all messages already sent by one user.
	 * 
	 * @param name
	 * @return
	 */
	public static SentMessages[] getMessagesPostedByUser(String name) {
		User user = UserManager.getUser(name);
		int userId = user.getId();
		SentMessages[] sentMessages = null;
		try {
			sentMessages = sentMessagesDao.findWhereUserIdEquals(userId);
		} catch (SentMessagesDaoException e) {
			e.printStackTrace();
		}
		if (sentMessages.length > 0)
			return sentMessages;
		return null;
	}

	public static Message getMessageByMessage(String message) {
		Message[] messages = null;
		try {
			messages = messageDao.findWhereMessageEquals(message);
			if (messages.length > 0)
				return messages[0];
		} catch (MessageDaoException m) {
			m.printStackTrace();
		}
		return null;
	}

	public static int getMessageIdByMessage(Message message) {
		if (message != null)
			return message.getId();
		System.out.println("Error: null menssage.");
		return -1;
	}

	/**
	 * Check if a message has already been posted by user.
	 * 
	 * @param accountName
	 *            user account name
	 * @param messageId
	 *            mesasge id (primary key)
	 * @return boolean
	 */
	public static boolean isMessageAlreadyPostedByUser(String accountName,
			String message) {
		SentMessages[] sentMessages = getMessagesPostedByUser(accountName);
		// If the user has posted messages:
		if (sentMessages.length > 0) {
			int messageId = getMessageIdByMessage(getMessageByMessage(message));
			for (SentMessages sentMessage : sentMessages) {
				if (sentMessage.getMessageId() == messageId)
					return true;
			}
		}
		return false;
	}
}