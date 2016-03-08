package be.yannick.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.yannick.entities.User;

public class UserDAO extends AbstractDAO {

	private static final String SQL_SELECT_USERNAME = "SELECT id, username, password, admin FROM users WHERE username=?";
	
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
	
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
			logger.log(Level.SEVERE, "Error in database MyUniverse with findUser()", ex);
			throw new DAOException(ex);
		}
		
	}
	
	private User mapRowToUser(ResultSet results) throws SQLException {
		return new User(results.getLong(User.ID), results.getString(User.USERNAME), results.getString(User.PASSWORD), results.getBoolean(User.ADMIN));
	}
	
	// TODO still needs other user queries on the database
	
}
