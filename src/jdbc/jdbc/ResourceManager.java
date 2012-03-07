package jdbc.jdbc;

import java.sql.*;

public class ResourceManager {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/mysql";

	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "root";

	private static Driver driver = null;

	private static Connection connection = null;

	public static synchronized Connection getConnection() {
		if (connection==null) {
			if (driver == null) {
				try {
					Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
					driver = (Driver) jdbcDriverClass.newInstance();
					DriverManager.registerDriver(driver);
				} catch (Exception e) {
					System.out.println("Failed to initialise JDBC driver");
					e.printStackTrace();
				}
			}

			// Singleton for the connection object:
			try {
				return DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
			} catch (SQLException s) {
				s.printStackTrace();
				return null;
			}
		} else
			return connection;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

}
