/**
 * 
 */
package edu.tan.poc.smartms.repository.jpa;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.tan.poc.smartms.model.User;
import edu.tan.poc.smartms.util.CommonConstants;

/**
 * @author tanmo
 *
 */
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_RDBMS)
public interface UserJpaRepository extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> {

}
