/**
 * 
 */
package pers.jssd.blog.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import pers.jssd.blog.bean.Blog;

/**
 * @author jssd
 *
 */
public interface BlogDao {

	/**
	 * 添加博客
	 * @param blogText
	 * @return boolean
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public boolean addBlog(Blog blogText) throws SQLIntegrityConstraintViolationException;
	
	/**
	 * 删除博客
	 * @param blogText
	 * @return boolean
	 */
	public boolean delBlog(Blog blogText);
	
	/**
	 * 更新博客
	 * @param blogText
	 * @return boolean
	 */
	public boolean updateBlog(Blog blogText);
	
	
	/**
	 * 查找用户
	 * @param blogText
	 * @return BlogText
	 */
	public List<Blog> queryBlog(Blog blogText);
}
