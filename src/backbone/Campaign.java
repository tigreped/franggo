package backbone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class used to model a campaign object and its atributes.
 * 
 * @author pedro
 * 
 */
public class Campaign {

	private String name = "";
	private String start = "";
	private String end = "";

	private ArrayList<String> hashtags = new ArrayList<String>();
	private ArrayList<Message> messages = new ArrayList<Message>();

	public Campaign(String name) {
		setName(name);
	}

	public Campaign(String name, String start, String end) {
		setName(name);
		setStart(start);
		setEnd(end);
	}

	public String fetchUpdateMessage(String user) {
		ArrayList<Message> filteredMessages = new ArrayList<Message>();

		for (Message msg : messages) {
			if (!msg.isUserRegistered(user))
				filteredMessages.add(msg);
		}

		Random r = new Random(System.currentTimeMillis());
		int random = 0;

		if (filteredMessages.size() > 0) {
			random = r.nextInt(filteredMessages.size());

			Message m = filteredMessages.get(random);

			try {
				m.addUser(user);
				return m.getMessage();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
	}

	/**
	 * Adds a new message to the campaign checking if the message already exists
	 * in the posts pool.
	 * 
	 * @param msg
	 *            the message to be added.
	 * @exception warns
	 *                that the message already exists in this campaign's posts
	 *                pool.
	 */
	public void addMessage(String msg) throws Exception {
		if (!messages.contains(msg))
			messages.add(new Message(msg));
		else
			throw new Exception("Message already registered in the posts pool.");
	}

	/**
	 * Loads the messages from the persistence file.
	 */
	public void loadMessages() {
		String filepath = "campanhas/" + getName();
		File file = new File(filepath);
		// File already exists, loads messages:
		if (file.exists()) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(filepath));
				String str;

				while ((str = in.readLine()) != null)
					messages.add(new Message(str));

				in.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * Saves the campaign messages to a text file on the hardrive.
	 */
	public void persistMessages() {
		try {
			// Start writing at the end of the file.
			PrintWriter pw = new PrintWriter(new FileWriter(
					"campanhas/" + name, true));

			for (Message msg : messages) {
				pw.println(msg.getMessage());
			}
			pw.flush();
			pw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		}
	}

	public void printMessages() {
		for (Message m : messages)
			System.out.println(m.getMessage());
	}

	public ArrayList<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(ArrayList<String> hashtags) {
		this.hashtags = hashtags;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
