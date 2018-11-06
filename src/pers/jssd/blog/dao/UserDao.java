/**
 * 
 */
package pers.jssd.blog.dao;

import java.sql.ResultSet;

import pers.jssd.blog.bean.User;

/**
 * @author jssd
 *
 */

public interface UserDao {
	
	
	public boolean addUser(User user);

	
	public boolean delUser(User user);
	
	public ResultSet queryUser(User user);
}
