package twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class UpdateStatus {
	/**
	 * Usage: java twitter4j.examples.tweets.UpdateStatus [text]
	 * 
	 * @param args
	 *            message
	 */
	public UpdateStatus(String msg) {

		try {
			Twitter twitter = new TwitterFactory().getInstance();
			Status status = twitter.updateStatus(msg);
			System.out.println("Status atualizado com sucesso para: \""
					+ status.getText() + "\"");
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			System.exit(-1);
		}
	}
}
