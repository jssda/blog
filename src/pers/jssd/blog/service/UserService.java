/**
 * 
 */
package pers.jssd.blog.service;

import pers.jssd.blog.bean.User;

/**
 * @author jssd
 *
 */
public interface UserService {
	
	/**
	 * @param user
	 * @return String
	 */
	public boolean checkPassword(User user);
	
}
