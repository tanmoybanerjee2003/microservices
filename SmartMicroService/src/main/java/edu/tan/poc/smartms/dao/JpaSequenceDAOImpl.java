/**
 * 
 */
package edu.tan.poc.smartms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import edu.tan.poc.smartms.util.CommonConstants;
import edu.tan.poc.smartms.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Repository("jpaSequenceDAO")
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_RDBMS)
public class JpaSequenceDAOImpl implements SequenceDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public long getNextId(String sequenceName) {
		long nextId = -1;
		try {
			//TOOD: Let's rewrite vendor agnostic way
			String nativeQuery = String.format("select nextval('%s')", sequenceName);
			Query query = em.createNativeQuery(nativeQuery);
			Object obj = query.getSingleResult();
			nextId = CommonUtil.intValue(obj);
		} catch(Exception ex) {
			String errMsg = "Error while retrieving next ID";
			log.error(errMsg, ex);
			throw new RuntimeException(errMsg, ex);
		}
		
		return nextId;
	}

}
