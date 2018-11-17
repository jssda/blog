/**
 * 
 */
package pers.jssd.blog.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.dao.UserDao;
import pers.jssd.blog.util.DBUtil;

/**
 * @author jssd
 *
 */
public class UserDaoImp implements UserDao{
	
	Connection conn = null;
	PreparedStatement sta = null;
	ResultSet rs = null;
	
	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#addUser(pers.jssd.blog.bean.User)
	 */
	@Override
	public boolean addUser(User user) throws SQLIntegrityConstraintViolationException{
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
			int index = 1;
			sta.setString(index ++, name);
			sta.setString(index ++, password);
			sta.setString(index ++, gender);
			if(age == null) {
				age = 0;
			}
			sta.setInt(index ++, age);
			sta.setString(index ++, telephone);
			sta.setString(index ++, email);
			sta.setString(index ++, introduction);
			sta.setTimestamp(index ++, new java.sql.Timestamp(createtime.getTime()));
			sta.setTimestamp(index ++, new java.sql.Timestamp(updatetime.getTime()));
			
			sta.execute();
			signal = true;
		} catch (SQLIntegrityConstraintViolationException icve) {
			throw icve;
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
			List<User> list = this.queryUserList(user);
			int count = list.size();
			if(count == 0) {
				signal = false;
			} else {
				conn = DBUtil.getConnection();
				String sql = "delete from user where id = ?";
				
				int i = 0;
				for(i = 0; i < count; i ++) {
					sta = conn.prepareStatement(sql);
					sta.setInt(1, list.get(i).getId());
					sta.execute();
				}
				if(i == count) {
					signal = true;
				} 
			}
		} catch (Exception e) {
			// TODO: handle exception
			signal = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, sta, rs);
		}
		
		return signal;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#queryUser(pers.jssd.blog.modle.User)
	 */
	@Override
	public List<User> queryUserList(User user) {
		// TODO Auto-generated method stub
		
		List<User> list = new ArrayList<User>();
		try {
			conn = DBUtil.getConnection();
			Integer id = user.getId();
			String name = user.getName();
			String password = user.getPassword();
			String gender = user.getGender();
			Integer age = user.getAge();
			String telephone = user.getTelephone();
			String email = user.getEmail();
			
			String sql = "select * from user where 1=1";
			//根据不同条件查询
			if(id != null) {
				sql += " and id=?";
			}
			if(name != null && !name.trim().equals("")) {
				sql += " and name=?";
			}
			if(password != null && !password.trim().equals("")) {
				sql += " and password=?";
			}
			if(gender != null && !gender.trim().equals("")) {
				sql += " and gender=?";
			}
			if(age != null) {
				sql += " and age=?";
			}
			if(telephone != null && !telephone.trim().equals("")) {
				sql += " and telephone=?";
			}
			if(email != null && !email.trim().equals("")) {
				sql += " and email=?";
			}
			sql += ";";
			sta = conn.prepareStatement(sql);
			//编译语句赋值
			int index = 1;
			if(id != null) {
				sta.setInt(index ++, id);
			}
			if(name != null && !name.trim().equals("")) {
				sta.setString(index ++, name);
			}
			if(password != null && !password.trim().equals("")) {
				sta.setString(index ++, password);
			}
			if(gender != null && !gender.trim().equals("")) {
				sta.setString(index ++, gender);
			}
			if(age != null) {
				sta.setInt(index ++, age);
			}
			if(telephone != null && !telephone.trim().equals("")) {
				sta.setString(index ++, telephone);
			}
			if(email != null && !email.trim().equals("")) {
				sta.setString(index ++, email);
			}
			
			rs = sta.executeQuery();
			while(rs.next()) {
				User u = new User();
				index = 1;
				u.setId(rs.getInt(index ++));
				u.setName(rs.getString(index ++));
				u.setPassword(rs.getString(index ++));
				u.setGender(rs.getString(index ++));
				u.setAge(rs.getInt(index ++));
				u.setTelephone(rs.getString(index ++));
				u.setEmail(rs.getString(index ++));
				u.setIntroduction(rs.getString(index ++));
				u.setCreatetime(rs.getDate(index ++));
				u.setUpdatetime(rs.getDate(index ++));
				list.add(u);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, sta, rs);
		}
		
		
		return list;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#modifyUser(pers.jssd.blog.bean.User)
	 */
	@Override
	public boolean modifyUser(User user) {
		// TODO Auto-generated method stub
		boolean signal = false;
		
		try {
			conn = DBUtil.getConnection();
			if(user.getId() == null) {
				List<User> list = this.queryUserList(user);
				if(list.size() != 1) {
					signal = false;
				} else {
					user.setId(list.get(0).getId());
				}
			} else {
				String sql = "update user set name=?, password=?, gender=?, age=?, "
						+ "telephone=?, email=?, introduction=?, updatetime=? where id = ";
				
				sta = conn.prepareStatement(sql);
				int index = 1;
				sta.setString(index ++, user.getName());
				sta.setString(index ++, user.getPassword());
				sta.setString(index ++, user.getGender());
				sta.setInt(index ++, user.getAge());
				sta.setString(index ++, user.getTelephone());
				sta.setString(index ++, user.getEmail());
				sta.setString(index ++, user.getIntroduction());
				sta.setTimestamp(index ++, new java.sql.Timestamp(new Date().getTime()));
				
				int count = sta.executeUpdate();
				if(count == 1) {
					signal = true;
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			signal = false;
			e.printStackTrace();
		}		
		
		return signal;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.UserDao#queryUser(pers.jssd.blog.bean.User)
	 */
	@Override
	public User queryUser(User user) {
		// TODO Auto-generated method stub
//		System.out.println(user);
		User u = null;
		try {
			if(user != null && (user.getId() != null || (user.getName() != null && !user.getName().trim().equals("")))) {
				conn = DBUtil.getConnection();
				String sql = "select * from user where 1=1";
				
				Integer id = user.getId();
				String name = user.getName();
				
				if(id != null) 
					sql += " and id = ?";
				if(name != null && !name.trim().equals(""))
					sql += " and name = ?";
				
				sql += ";";
				sta = conn.prepareStatement(sql);
				
				int index = 1;
				if(id != null) 
					sta.setInt(index ++, id);
				if(name != null && !name.trim().equals(""))
					sta.setString(index ++, name);
				
				rs = sta.executeQuery();
				while(rs.next()) {
					u = new User();
					index = 1;
					u.setId(rs.getInt(index ++));
					u.setName(rs.getString(index ++));
					u.setPassword(rs.getString(index ++));
					u.setGender(rs.getString(index ++));
					u.setAge(rs.getInt(index ++));
					u.setTelephone(rs.getString(index ++));
					u.setEmail(rs.getString(index ++));
					u.setIntroduction(rs.getString(index ++));
					u.setCreatetime(rs.getTimestamp(index ++));
					u.setUpdatetime(rs.getTimestamp(index ++));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("单个用户查询失败");
		} finally {
			DBUtil.closeConnection(conn, sta, rs);
		}
		
		return u;
	}

}
