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

public interface UserDao
{
	/** 
	 * Inserts a new row in the USER table.
	 */
	public UserPk insert(User dto) throws UserDaoException;

	/** 
	 * Updates a single row in the USER table.
	 */
	public void update(UserPk pk, User dto) throws UserDaoException;

	/** 
	 * Deletes a single row in the USER table.
	 */
	public void delete(UserPk pk) throws UserDaoException;

	/** 
	 * Returns the rows from the USER table that matches the specified primary-key value.
	 */
	public User findByPrimaryKey(UserPk pk) throws UserDaoException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'ID = :id'.
	 */
	public User findByPrimaryKey(int id) throws UserDaoException;

	/** 
	 * Returns all rows from the USER table that match the criteria ''.
	 */
	public User[] findAll() throws UserDaoException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'ID = :id'.
	 */
	public User[] findWhereIdEquals(int id) throws UserDaoException;

	/** 
	 * Returns all rows from the USER table that match the criteria 'ACCOUNT_NAME = :accountName'.
	 */
	public User[] findWhereAccountNameEquals(String accountName) throws UserDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the USER table that match the specified arbitrary SQL statement
	 */
	public User[] findByDynamicSelect(String sql, Object[] sqlParams) throws UserDaoException;

	/** 
	 * Returns all rows from the USER table that match the specified arbitrary SQL statement
	 */
	public User[] findByDynamicWhere(String sql, Object[] sqlParams) throws UserDaoException;

}