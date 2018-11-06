/**
 * 
 */
package pers.jssd.blog.test;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.dao.UserDao;
import pers.jssd.blog.daoImp.UserDaoImp;

/**
 * @author jssd
 *
 */
public class InsertTest {
	
	public static void main(String[] args) {
		User user = new User();
		user.setName("jssd");
		user.setPassword("142536");
		user.setGender("man");
		user.setAge(20);
		user.setTelephone("15188875022");
		user.setEmail("1624022009@qq.com");
		user.setIntroduction("本宝宝还没有想好");
		
		UserDao userDaoImp = new UserDaoImp();
		userDaoImp.addUser(user);
	}
	
}
