package manager;

import java.util.ArrayList;

public class MessageManager {
	
	private ArrayList<String> users = new ArrayList<String>();
	private String message;
	
	public MessageManager(String msg) {
		setMessage(msg);
	}
	
	public void addUser(String user) throws Exception {
		if (!isUserRegistered(user)) {
			users.add(user);
		}
		else {
			throw new Exception("User already registered to this message.");
		}
	}
	
	public boolean isUserRegistered(String user) {
		if (users.contains(user))
			return true;
		return false;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
