/**
 * 
 */
package edu.tan.poc.smartms.dao;

/**
 * @author tanmo
 *
 */
public interface SequenceDAO {
	/**
	 * 
	 * @param sequenceName name of the sequence
	 * @return next value from the sequence
	 */
	public long getNextId(String sequenceName);
}
