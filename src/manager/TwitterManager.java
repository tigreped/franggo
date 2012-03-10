package manager;

import twitter.UpdateStatus;
import util.PropertiesManager;

/**
 * This class manages all operations regarding the twitter interface. 
 * @author Pedro Guimarães
 *
 */
public class TwitterManager {
	
	/**
	 * Loads user properties at twitter4j.properties, posts update for user and updates database.
	 * @param campaign
	 * @param accountName
	 * @param txt
	 */
	public static void updateStatus(String campaign, String accountName, String txt) {
		try {
			PropertiesManager.loadProperties(accountName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new UpdateStatus(txt);
		// TODO: Add sentmessage regiter;
	}
}
