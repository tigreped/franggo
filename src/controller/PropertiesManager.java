package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * This class is responsible for all properties management operations.
 * @author Pedro Guimarães
 * @date 04/03/2012
 *
 */
public class PropertiesManager {

	/**
	 * Loads the user properties into the general twitter4j properties file
	 * @param user
	 * @throws Exception user properties not found exception
	 */
	public static void loadProperties(String user) throws Exception {

		String filepath = "properties/" + user;

		File userFile = new File(filepath);

		File propertiesFile = new File("twitter4j.properties");

		Properties twitter4jProperties = new Properties();
		
		Properties userProperties = new Properties();
		
		InputStream twitter4jInputStream = null;
		
		InputStream userInputStream = null;
		
		OutputStream twitter4jOutputStream = null;
		
		if (propertiesFile.exists()) {	
			twitter4jInputStream = new FileInputStream(propertiesFile);
			twitter4jProperties.load(twitter4jInputStream);
			twitter4jOutputStream = new FileOutputStream("twitter4j.properties");
		}

		// File already exists, loads messages:
		if (userFile.exists()) {
			userInputStream = new FileInputStream(userFile);
			userProperties.load(userInputStream);
			
			// Gets user consumer key from user properties file:
			String userConsumerKey = userProperties.getProperty("oauth.accessToken");
			// Sets user consumer key at twitter4j properties file:
			twitter4jProperties.setProperty("oauth.accessToken", userConsumerKey);
			// Gets user consumer secret from user properties file:
			String userConsumerSecret = userProperties.getProperty("oauth.accessTokenSecret");
			// Sets user consumer secret at twitter4j properties file:
			twitter4jProperties.setProperty("oauth.accessTokenSecret", userConsumerSecret);
			
			// Save properties:
			twitter4jProperties.store(twitter4jOutputStream, "twitter4j.properties");

			// Close streams: 
			twitter4jInputStream.close();
			twitter4jOutputStream.close();
			userInputStream.close();
			
		}
		// File does not exist, throws error message:
		else {
			throw new Exception(
					"Arquivo de properties não encontrado para o usuário: "
							+ user);
		}
		
	} //End of loadProperties() method.
	
} //EOF
