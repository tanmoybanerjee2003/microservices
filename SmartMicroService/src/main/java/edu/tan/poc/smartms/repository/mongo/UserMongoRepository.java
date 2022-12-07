/**
 * 
 */
package edu.tan.poc.smartms.repository.mongo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.tan.poc.smartms.model.User;
import edu.tan.poc.smartms.util.CommonConstants;

/**
 * @author tanmo
 *
 */
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_MONGODB)
public interface UserMongoRepository extends MongoRepository<User, String> {

}
