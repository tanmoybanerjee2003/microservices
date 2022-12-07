/**
 * 
 */
package edu.tan.poc.smartms.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import edu.tan.poc.smartms.dao.UserDAO;
import edu.tan.poc.smartms.util.CommonUtil;
import edu.tan.poc.smartms.vo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tanmo
 *
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	
	@Autowired
	private ApplicationContext ctx;
	
	@Value("${app.store.type}")
	private String appStoreType;
	
	/*
	 * Depending on "app.store.type", 
	 * DAO for RDBMS, MongoDB or Elasticsearch will be used
	 */
	@PostConstruct
	private void init() {
		//TODO: throw invalid configuration exception if bean can't be found
		userDAO = ctx.getBean(appStoreType, UserDAO.class);
	}
	
	@Override
	public void save(User user) {
		if(user != null) {
			userDAO.create(CommonUtil.populateUserModelFromVO(user));
		} else {
			log.error("Won't save null object.");
		}
	}
}
