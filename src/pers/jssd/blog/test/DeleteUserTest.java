/**
 * 
 */
package pers.jssd.blog.test;

import java.sql.ResultSet;
import java.util.List;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.dao.UserDao;
import pers.jssd.blog.dao.Imp.UserDaoImp;

/**
 * @author jssd
 *
 */
public class DeleteUserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(2);
		UserDao userDao = new UserDaoImp();
		boolean signal = userDao.delUser(user);
		System.out.println(signal);
//		List<User> list = userDao.queryUser(user);
//		for(int i = 0; i < list.size(); i ++) {
//			System.out.println(list.get(i));
//		}
	}

}
