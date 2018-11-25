/**
 * 
 */
package pers.jssd.blog.service;

import java.sql.SQLIntegrityConstraintViolationException;

import pers.jssd.blog.bean.User;

/**
 * @author jssd
 *
 */
public interface UserService {
	
	/**
	 * 注册用户
	 * @param user
	 * @return boolean
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public boolean registerUser(User user) throws SQLIntegrityConstraintViolationException;
	
	
	/**
	 * @param user
	 * @return User
	 */
	public User getUser(User user);
	
	/**
	 * @param user
	 * @return boolean
	 */
	public boolean modifyUser(User user);
	
}
