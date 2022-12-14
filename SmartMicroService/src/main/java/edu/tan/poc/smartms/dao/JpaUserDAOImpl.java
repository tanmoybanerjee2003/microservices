/**
 * 
 */
package edu.tan.poc.smartms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import edu.tan.poc.smartms.model.User;
import edu.tan.poc.smartms.repository.jpa.UserJpaRepository;
import edu.tan.poc.smartms.util.CommonConstants;
import edu.tan.poc.smartms.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Repository(CommonConstants.STORE_TYPE_RDBMS)
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_RDBMS)
public class JpaUserDAOImpl implements UserDAO {
	private final boolean isDebugEnabled = log.isDebugEnabled();
	
	@Autowired
	private UserJpaRepository userRepo;
	
	@Autowired
	@Qualifier("jpaSequenceDAO")
	private SequenceDAO sequenceDAO;
	
	@Override
	public void create(User user) {
		if(user != null) {
			if(user.getUserId() == null) {
				if(isDebugEnabled) {
					log.debug("Going to generate user ID");
				}
				long userId = sequenceDAO.getNextId(CommonConstants.RDBMS_USER_ID_SEQUENCE);
				if(isDebugEnabled) {
					log.debug("Generated user ID: {}", userId);
				}
				user.setUserId((int)userId);
			}
			if(isDebugEnabled) {
				log.debug("Going to insert following user object: {}", user);
			}
			userRepo.save(user);
			if(isDebugEnabled) {
				log.debug("User has been saved successfully.");
			}
		} else {
			log.error("Ignored null object.");
		}
	}

}
