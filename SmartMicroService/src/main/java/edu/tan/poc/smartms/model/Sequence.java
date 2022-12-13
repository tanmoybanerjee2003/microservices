/**
 * 
 */
package edu.tan.poc.smartms.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.tan.poc.smartms.util.CommonConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tanmo
 *
 */
@Getter
@Setter
@ConditionalOnProperty(name = "app.store.type", havingValue = CommonConstants.STORE_TYPE_MONGODB)
@Document(collection = "sequence")
public class Sequence {
	@Id
	private String id;
	private long seq;
}
