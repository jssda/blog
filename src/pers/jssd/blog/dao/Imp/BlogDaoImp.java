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

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.dao.BlogDao;
import pers.jssd.blog.util.DBUtil;

/**
 * @author jssd
 *
 */
public class BlogDaoImp implements BlogDao {

	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.blogDao#addBlog(pers.jssd.blog.bean.blog)
	 */
	@Override
	public boolean addBlog(Blog blog) throws SQLIntegrityConstraintViolationException{
		// TODO Auto-generated method stub
		boolean signal = false;
		
		try {
			conn = DBUtil.getConnection();
			String author = blog.getAuthor();
			String title = blog.getTitle();
			String info = blog.getInfo();
			String type = blog.getType();
			Date createTime = new Date();
			Date updateTime = new Date();
			Integer visitCount = 0;
			String content = blog.getContent();
			
			String sql = "insert into blog VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(sql);
			int index = 1;
			ps.setString(index ++, author);
			ps.setString(index ++, title);
			ps.setString(index ++, info);
			ps.setString(index ++, type);
			ps.setTimestamp(index ++, new java.sql.Timestamp(createTime.getTime()));
			ps.setTimestamp(index ++, new java.sql.Timestamp(updateTime.getTime()));
			ps.setInt(index ++, visitCount);
			ps.setString(index, content);
			ps.execute();
			signal = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			signal = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
		
		return signal;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.blogDao#delBlog(pers.jssd.blog.bean.blog)
	 */
	@Override
	public boolean delBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		boolean signal = false;

		try {
			List<Blog> list = this.queryBlog(blog);
			int count = list.size();
			if(count != 1) {
				signal = false;
			} else {
				conn = DBUtil.getConnection();
				String sql = "delete from blog where id = ?;";
				
				int i = 0;
				for(i = 0; i < count; i ++) {
					ps = conn.prepareStatement(sql);
					ps.setInt(1, list.get(i).getId());
					ps.execute();
				}
				if(i == count) {
					signal = true;
				} 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			signal = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
		
		return signal;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.blogDao#updateBlog(pers.jssd.blog.bean.blog)
	 */
	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		boolean signal = false;
		
		try {
			conn = DBUtil.getConnection();
			if(blog.getId() == null) {
				List<Blog> list = this.queryBlog(blog);
				if(list.size() != 1) {
					signal = false;
				} else {
					blog.setId(list.get(0).getId());
				}
			} else {
				String sql = "update blog set auther=?, title=?, info=?, type=?, updatetime=?, visitcount=?, content=?;";
				ps = conn.prepareStatement(sql);
				int index = 1;
				ps.setString(index ++, blog.getAuthor());
				ps.setString(index ++, blog.getTitle());
				ps.setString(index ++, blog.getInfo());
				ps.setString(index ++, blog.getType());
				ps.setTimestamp(index ++, new java.sql.Timestamp(new Date().getTime()));
				ps.setInt(index ++, blog.getVisitCount());
				ps.setString(index ++, blog.getContent());
				
				int count = ps.executeUpdate();
				if(count == 1) {
					signal = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			signal = false;
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
		
		return signal;
	}

	/* (non-Javadoc)
	 * @see pers.jssd.blog.dao.blogDao#queryBlog(pers.jssd.blog.bean.blog)
	 */
	@Override
	public List<Blog> queryBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		List<Blog> list = new ArrayList<Blog>();
		
		try {
			conn = DBUtil.getConnection();
			Integer id = blog.getId();
			String auther = blog.getAuthor();
			String title = blog.getTitle();
			String info = blog.getInfo();
			String type = blog.getType();
			Integer visitCount = blog.getVisitCount();
			
			String sql = "select * from blog where 1=1";
			//根据不同条件查询
			if(id != null)
				sql += " and id = ?";
			if(auther != null && !auther.trim().equals(""))
				sql += " and auther = ?";
			if(title != null && !title.trim().equals(""))
				sql += " and title = ?";
			if(info != null && !info.trim().equals(""))
				sql += " and info = ?";
			if(type != null && !type.trim().equals(""))
				sql += " and type = ?";
			if(visitCount != null)
				sql += " and visitcount = ?";
			sql += ";";
			ps = conn.prepareStatement(sql);
			
			//编译赋值
			int index = 1;
			if(id != null)
				ps.setInt(index ++, id);
			if(auther != null && !auther.trim().equals(""))
				ps.setString(index ++, auther);
			if(title != null && !title.trim().equals(""))
				ps.setString(index ++, title);
			if(info != null && !info.trim().equals(""))
				ps.setString(index ++, info);
			if(type != null && !type.trim().equals(""))
				ps.setString(index ++, type);
			if(visitCount != null)
				ps.setInt(index ++, visitCount);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Blog bt = new Blog();
				index = 1;
				bt.setId(rs.getInt(index ++));
				bt.setAuthor(rs.getString(index ++));
				bt.setTitle(rs.getString(index ++));
				bt.setInfo(rs.getString(index ++));
				bt.setType(rs.getString(index ++));
				bt.setCreateTime(rs.getTimestamp(index ++));
				bt.setUpdateTime(rs.getTimestamp(index ++));
				bt.setVisitCount(rs.getInt(index ++));
				bt.setContent(rs.getString(index ++));
				list.add(bt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, ps, rs);
		}
			
		return list;
	}

}
