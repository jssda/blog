/**
 * 
 */
package pers.jssd.blog.dao;

import java.util.List;

import pers.jssd.blog.bean.User;

/**
 * @author jssd
 *
 */

public interface UserDao {
	
	
	/**
	 * 添加用户
	 * @param user
	 * @return boolean
	 */
	public boolean addUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return boolean
	 */
	public boolean delUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return boolean
	 */
	public boolean modifyUser(User user);
	
	/**
	 * 查询用户
	 * @param user
	 * @return List<User>
	 */
	public List<User> queryUser(User user);
	
}
