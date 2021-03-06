/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package jdbc.dto;

import jdbc.dao.*;
import jdbc.factory.*;
import jdbc.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable
{
	/** 
	 * This attribute maps to the column ID in the USER table.
	 */
	protected int id;

	/** 
	 * This attribute maps to the column ACCOUNT_NAME in the USER table.
	 */
	protected String accountName;

	/**
	 * Method 'User'
	 * 
	 */
	public User()
	{
	}

	/**
	 * Method 'getId'
	 * 
	 * @return int
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Method 'setId'
	 * 
	 * @param id
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Method 'getAccountName'
	 * 
	 * @return String
	 */
	public String getAccountName()
	{
		return accountName;
	}

	/**
	 * Method 'setAccountName'
	 * 
	 * @param accountName
	 */
	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof User)) {
			return false;
		}
		
		final User _cast = (User) _other;
		if (id != _cast.id) {
			return false;
		}
		
		if (accountName == null ? _cast.accountName != accountName : !accountName.equals( _cast.accountName )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + id;
		if (accountName != null) {
			_hashCode = 29 * _hashCode + accountName.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UserPk
	 */
	public UserPk createPk()
	{
		return new UserPk(id);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "jdbc.dto.User: " );
		ret.append( "id=" + id );
		ret.append( ", accountName=" + accountName );
		return ret.toString();
	}

}
