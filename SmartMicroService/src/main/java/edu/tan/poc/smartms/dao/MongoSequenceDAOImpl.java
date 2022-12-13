/**
 * 
 */
package edu.tan.poc.smartms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import edu.tan.poc.smartms.model.Sequence;
import edu.tan.poc.smartms.util.CommonConstants;

/**
 * @author tanmo
 *
 */
@Repository("mongoSequenceDAO")
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_MONGODB)
public class MongoSequenceDAOImpl implements SequenceDAO {
	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public long getNextId(String sequenceName) {
		//Query to get sequence ID
		Query query = new Query(Criteria.where("_id").is(sequenceName));
		
		//increase sequence ID by 1
		Update update = new Update();
		update.inc("seq", 1);
		
		//retrieve the value from MongoDB and increase the sequence
		FindAndModifyOptions famOptions = new FindAndModifyOptions();
		famOptions.returnNew(true);
		Sequence sequence = mongoOperations.findAndModify(query, update, famOptions, Sequence.class);
		
		if(sequence == null) {
			throw new RuntimeException("Unable to get next Id from sequence: " + sequenceName);
		}
		
		return sequence.getSeq();
	}

}
