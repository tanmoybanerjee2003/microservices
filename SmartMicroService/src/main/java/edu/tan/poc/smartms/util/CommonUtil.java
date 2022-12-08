/**
 * 
 */
package edu.tan.poc.smartms.util;

import edu.tan.poc.smartms.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
public final class CommonUtil {
	private CommonUtil() {}
	
	/**
	 * 
	 * @param str
	 * @return true if str is null or empty; false otherwise
	 */
	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}
	
	/**
	 * 
	 * @param obj
	 * @return integer value of the object
	 */
	public static int intValue(Object obj) {
		if(obj == null) {
			throw new NumberFormatException("Null string can't be parsed into an integer.");
		}
		
		return Integer.parseInt(obj.toString());
	}
	
	/**
	 * Utility method to populate user model from user POJO
	 * 
	 * @param userVO
	 * @return user
	 */
	public static User populateUserModelFromVO(edu.tan.poc.smartms.vo.User userVO) {
		User user = null;
		
		if(userVO != null) {
			user = new User();
			String userId = userVO.getUserId();
			if(!isEmpty(userId)) {
				user.setUserId(intValue(userId));
			}
			user.setFirstName(userVO.getFirstName());
			user.setMiddleName(userVO.getMiddleName());
			user.setLastName(userVO.getLastName());
		} else {
			log.error("Ignored null object for population.");
		}
		
		return user;
	}
}
