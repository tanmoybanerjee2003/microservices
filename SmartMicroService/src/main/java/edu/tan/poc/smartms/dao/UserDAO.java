/**
 * 
 */
package edu.tan.poc.smartms.dao;

import edu.tan.poc.smartms.model.User;

/**
 * @author tanmo
 *
 */
public interface UserDAO {
	/**
	 * Create user in the underlying persistence store
	 * 
	 * @param user
	 */
	public void create(User user);
}
