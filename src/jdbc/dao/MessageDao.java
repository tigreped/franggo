/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package jdbc.dao;

import jdbc.dto.*;
import jdbc.exceptions.*;

public interface MessageDao
{
	/** 
	 * Inserts a new row in the MESSAGE table.
	 */
	public MessagePk insert(Message dto) throws MessageDaoException;

	/** 
	 * Updates a single row in the MESSAGE table.
	 */
	public void update(MessagePk pk, Message dto) throws MessageDaoException;

	/** 
	 * Deletes a single row in the MESSAGE table.
	 */
	public void delete(MessagePk pk) throws MessageDaoException;

	/** 
	 * Returns the rows from the MESSAGE table that matches the specified primary-key value.
	 */
	public Message findByPrimaryKey(MessagePk pk) throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the criteria 'ID = :id'.
	 */
	public Message findByPrimaryKey(int id) throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the criteria ''.
	 */
	public Message[] findAll() throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the criteria 'ID = :id'.
	 */
	public Message[] findWhereIdEquals(int id) throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the criteria 'CAMPAIGN_ID = :campaignId'.
	 */
	public Message[] findWhereCampaignIdEquals(int campaignId) throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the criteria 'USER_ID = :userId'.
	 */
	public Message[] findWhereUserIdEquals(int userId) throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the criteria 'MESSAGE = :message'.
	 */
	public Message[] findWhereMessageEquals(String message) throws MessageDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the MESSAGE table that match the specified arbitrary SQL statement
	 */
	public Message[] findByDynamicSelect(String sql, Object[] sqlParams) throws MessageDaoException;

	/** 
	 * Returns all rows from the MESSAGE table that match the specified arbitrary SQL statement
	 */
	public Message[] findByDynamicWhere(String sql, Object[] sqlParams) throws MessageDaoException;

}
