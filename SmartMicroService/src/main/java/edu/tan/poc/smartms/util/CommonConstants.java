/**
 * 
 */
package edu.tan.poc.smartms.util;

/**
 * @author tanmo
 *
 */
public interface CommonConstants {
	String STORE_TYPE_RDBMS = "rdbms";
	String STORE_TYPE_ELASTICSEARCH = "elasticsearch";
	String STORE_TYPE_MONGODB = "mongodb";
	
	//sequences
	String RDBMS_USER_ID_SEQUENCE = "tbl_user_seq";
	String MONGO_USER_ID_SEQUENCE = "user_seq";
}
