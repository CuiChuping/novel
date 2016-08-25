package com.microc.novel.basic.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;


public class SimpleDataSource implements DataSource {
	
	private String driverClassName;
	private String jdbcURL;
	private String userName;
	private String password;

	public void setDriverClassName(String driverClassName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.driverClassName = driverClassName;
		Class.forName(this.driverClassName, true, Thread.currentThread().getContextClassLoader());
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns a Connection using the DriverManager and all set properties.
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if (userName != null) {
			conn = DriverManager.getConnection(jdbcURL, userName, password);
		} else {
			conn = DriverManager.getConnection(jdbcURL);
		}
		return conn;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

}
