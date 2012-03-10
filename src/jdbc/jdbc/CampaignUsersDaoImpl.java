/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package jdbc.jdbc;

import jdbc.dao.*;
import jdbc.factory.*;
import jdbc.dto.*;
import jdbc.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class CampaignUsersDaoImpl extends AbstractDAO implements CampaignUsersDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT CAMPAIGN_ID, USER_ID FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( CAMPAIGN_ID, USER_ID ) VALUES ( ?, ? )";

	/** 
	 * Index of column CAMPAIGN_ID
	 */
	protected static final int COLUMN_CAMPAIGN_ID = 1;

	/** 
	 * Index of column USER_ID
	 */
	protected static final int COLUMN_USER_ID = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Inserts a new row in the CAMPAIGN_USERS table.
	 */
	public void insert(CampaignUsers dto) throws CampaignUsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			if (dto.isCampaignIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getCampaignId() );
			}
		
			if (dto.isUserIdNull()) {
				stmt.setNull( index++, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( index++, dto.getUserId() );
			}
		
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CampaignUsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the CAMPAIGN_USERS table that match the criteria ''.
	 */
	public CampaignUsers[] findAll() throws CampaignUsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT, null );
	}

	/** 
	 * Returns all rows from the CAMPAIGN_USERS table that match the criteria 'CAMPAIGN_ID = :campaignId'.
	 */
	public CampaignUsers[] findWhereCampaignIdEquals(int campaignId) throws CampaignUsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE CAMPAIGN_ID = ? ORDER BY CAMPAIGN_ID", new Object[] {  new Integer(campaignId) } );
	}

	/** 
	 * Returns all rows from the CAMPAIGN_USERS table that match the criteria 'USER_ID = :userId'.
	 */
	public CampaignUsers[] findWhereUserIdEquals(int userId) throws CampaignUsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE USER_ID = ? ORDER BY USER_ID", new Object[] {  new Integer(userId) } );
	}

	/**
	 * Method 'CampaignUsersDaoImpl'
	 * 
	 */
	public CampaignUsersDaoImpl()
	{
	}

	/**
	 * Method 'CampaignUsersDaoImpl'
	 * 
	 * @param userConn
	 */
	public CampaignUsersDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "Franggo.CAMPAIGN_USERS";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected CampaignUsers fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			CampaignUsers dto = new CampaignUsers();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected CampaignUsers[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			CampaignUsers dto = new CampaignUsers();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		CampaignUsers ret[] = new CampaignUsers[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(CampaignUsers dto, ResultSet rs) throws SQLException
	{
		dto.setCampaignId( rs.getInt( COLUMN_CAMPAIGN_ID ) );
		if (rs.wasNull()) {
			dto.setCampaignIdNull( true );
		}
		
		dto.setUserId( rs.getInt( COLUMN_USER_ID ) );
		if (rs.wasNull()) {
			dto.setUserIdNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(CampaignUsers dto)
	{
	}

	/** 
	 * Returns all rows from the CAMPAIGN_USERS table that match the specified arbitrary SQL statement
	 */
	public CampaignUsers[] findByDynamicSelect(String sql, Object[] sqlParams) throws CampaignUsersDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CampaignUsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the CAMPAIGN_USERS table that match the specified arbitrary SQL statement
	 */
	public CampaignUsers[] findByDynamicWhere(String sql, Object[] sqlParams) throws CampaignUsersDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CampaignUsersDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
