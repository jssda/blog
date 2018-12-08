/**
 * 
 */
package pers.jssd.blog.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pers.jssd.blog.bean.Type;
import pers.jssd.blog.dao.TypeDao;
import pers.jssd.blog.util.DBUtil;

/**
 * @author jssd
 *
 */
public class TypeDaoImp implements TypeDao {

	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.TypeDao#addType(pers.jssd.blog.bean.Type)
	 */
	@Override
	public boolean addType(Type type) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			connection = DBUtil.getConnection();
			String t = type.getType();
			String sql = "INSERT INTO type VALUES(null, ?);";
			ps = connection.prepareStatement(sql);
			ps.setString(1, t);
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.TypeDao#queryTypeList(pers.jssd.blog.bean.Type)
	 */
	@Override
	public List<Type> queryTypeList(Type type) {
		// TODO Auto-generated method stub
		List<Type> list = new ArrayList<>();
		try {
			connection = DBUtil.getConnection();
			String sql = "select * from type where 1=1";
			Integer id = type.getId();
			String ty = type.getType();
				
			if(id != null)
				sql += " and id = ?";
			if(ty != null && !ty.trim().equals(""))
				sql += " and type = ?";
				
			sql +=";";
			ps = connection.prepareStatement(sql);
			int index = 1;
			if(id != null)
				ps.setInt(index ++, id);
			if(ty != null && !ty.trim().equals(""))
				ps.setString(index ++, ty);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Type t = new Type();
				index = 1;
				t.setId(rs.getInt(index ++));
				t.setType(rs.getString(index ++));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection, ps, rs);
		}
		
		return list;
	}

}
