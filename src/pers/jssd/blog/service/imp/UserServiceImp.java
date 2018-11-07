/**
 * 
 */
package pers.jssd.blog.service.imp;

import java.util.List;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.dao.UserDao;
import pers.jssd.blog.dao.Imp.UserDaoImp;
import pers.jssd.blog.service.UserService;

/**
 * @author jssd
 *
 */
public class UserServiceImp implements UserService {

	UserDao userDao = new UserDaoImp();
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.UserService#checkPassword(pers.jssd.blog.bean.User)
	 */
	@Override
	public boolean checkPassword(User user) {
		// TODO Auto-generated method stub
		
		Boolean signal = false;
		List<User> list = null;
		if(user == null || "".equals(user.getName()) || "".equals(user.getPassword())) {
			signal = false;
		} else {
			list = userDao.queryUser(user);
			if(list.size() == 1) {
				signal = true;
				System.out.println(list.get(0));
			}
		}
		
		return signal;
	}
}
