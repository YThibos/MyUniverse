package be.yannick.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.yannick.entities.User;

public class UserDAO extends AbstractDAO {

	private static final String SQL_SELECT_USERNAME = "SELECT id, username, password FROM users WHERE username=?";
	
	public User findUser(String username) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USERNAME)) {
			
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			
			//Transaction isolation level = READ_COMMITTED && SELECT sent only once
			//--> No need to commit
			//connection.commit();
			
			if (results.next())	return mapRowToUser(results);
			
			// USER NOT FOUND
			return null;
			
		}
		catch (SQLException ex ) {
			throw new DAOException(ex);
		}
		
	}
	
	private User mapRowToUser(ResultSet results) throws SQLException {
		return new User(results.getLong(User.ID), results.getString(User.USERNAME), results.getString(User.PASSWORD), false);
	}
	
	// TODO still needs other user queries on the database
	
}
