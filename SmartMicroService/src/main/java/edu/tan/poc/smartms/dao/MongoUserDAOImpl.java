/**
 * 
 */
package edu.tan.poc.smartms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import edu.tan.poc.smartms.model.User;
import edu.tan.poc.smartms.repository.mongo.UserMongoRepository;
import edu.tan.poc.smartms.util.CommonConstants;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Repository(CommonConstants.STORE_TYPE_MONGODB)
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_MONGODB)
public class MongoUserDAOImpl implements UserDAO {
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@Autowired
	private UserMongoRepository userRepo;
	
	@Override
	public void create(User user) {
		throw new RuntimeException("Not yet implemented.");
	}

}
