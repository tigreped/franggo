/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package jdbc.factory;

import java.sql.Connection;
import jdbc.dao.*;
import jdbc.jdbc.*;

public class SentMessagesDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return SentMessagesDao
	 */
	public static SentMessagesDao create()
	{
		return new SentMessagesDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return SentMessagesDao
	 */
	public static SentMessagesDao create(Connection conn)
	{
		return new SentMessagesDaoImpl( conn );
	}

}
