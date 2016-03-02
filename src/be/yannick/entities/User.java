package be.yannick.entities;

import java.io.Serializable;

/**
 * Entity representing a user as used in the database
 * 
 * @author yannick.thibos
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The User class has a collection of public static final Strings that correspond to the matching
	 * fields in the database.
	 */
	public static final String USERNAME = "username";
	/**@see User#USERNAME*/
	public static final String PASSWORD = "password";
	/**@see User#USERNAME*/
	public static final String ID = "id";
	/**@see User#USERNAME*/
	public static final String ADMIN = "admin";
	
	private long id;
	private String username;
	private String password;
	private boolean admin;

	// CONSTRUCTORS
	public User(long id, String username, String password, boolean admin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	
	// GETTERS & SETTERS
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if (isValidString(username))this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if (isValidString(password))this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	/**
	 * Hashcode based on id
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/**
	 * Two users are considered equal if they have the same id (unique in database)
	 * or when they reference the same object.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public static boolean isValidString(String string) {
		return (string != null && "".equals(string));
	}
	
}
