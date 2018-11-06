/**
 * 
 */
package pers.jssd.blog.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.dao.UserDao;
import pers.jssd.blog.util.DBUtil;

/**
 * @author jssd
 *
 */
public class UserDaoImp implements UserDao{
	
	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#addUser(pers.jssd.blog.modle.User)
	 */
	
	Connection conn = null;
	PreparedStatement sta = null;
	ResultSet rs = null;
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Boolean signal = false;
		
		try {
			conn = DBUtil.getConnection();
			String name = user.getName();
			String password = user.getPassword();
			String gender = user.getGender();
			Integer age = user.getAge();
			String telephone = user.getTelephone();
			String email = user.getEmail();
			String introduction = user.getIntroduction();
			Date createtime = new Date();
			Date updatetime = new Date();
			
			String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			sta = conn.prepareStatement(sql);
			sta.setString(1, name);
			sta.setString(2, password);
			sta.setString(3, gender);
			sta.setInt(4, age);
			sta.setString(5, telephone);
			sta.setString(6, email);
			sta.setString(7, introduction);
			sta.setDate(8, new java.sql.Date(createtime.getTime()));
			sta.setDate(9, new java.sql.Date(updatetime.getTime()));
			
			signal = sta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			signal = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, sta, rs);
		}
		return signal; 
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#delUser(pers.jssd.blog.modle.User)
	 */
	@Override
	public boolean delUser(User user) {
		// TODO Auto-generated method stub
		boolean signal = false;
		
		try {
			conn = DBUtil.getConnection();
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBUtil.closeConnection(conn, sta, rs);
		}
		
		return signal;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#queryUser(pers.jssd.blog.modle.User)
	 */
	@Override
	public ResultSet queryUser(User user) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
	
}
