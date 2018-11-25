/**
 * 
 */
package pers.jssd.blog.service.imp;

import java.sql.SQLIntegrityConstraintViolationException;

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
	 * @see pers.jssd.blog.service.UserService#registerUser(pers.jssd.blog.bean.User)
	 */
	@Override
	public boolean registerUser(User user) throws SQLIntegrityConstraintViolationException{
		// TODO Auto-generated method stub
		boolean signal = false;
		try {
			signal =  userDao.addUser(user);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw e;
		}
		return signal;
	}
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.UserService#getUserId(pers.jssd.blog.bean.User)
	 */
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.queryUser(user);
	}
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.UserService#modifyUser(pers.jssd.blog.bean.User)
	 */
	@Override
	public boolean modifyUser(User user) {
		// TODO Auto-generated method stub
		return userDao.modifyUser(user);
	}
}
