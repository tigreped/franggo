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

public class MessageDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return MessageDao
	 */
	public static MessageDao create()
	{
		return new MessageDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return MessageDao
	 */
	public static MessageDao create(Connection conn)
	{
		return new MessageDaoImpl( conn );
	}

}
