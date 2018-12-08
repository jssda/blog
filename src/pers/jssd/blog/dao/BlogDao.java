/**
 * 
 */
package pers.jssd.blog.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.bean.PageBean;

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
	 * @param blogText
	 * @param currPage
	 * @param pageSize
	 * @return List<Blog>
	 */
	public List<Blog> queryBlog(Blog blogText, int currPage, int pageSize);
	
	/**
	 * @param blog
	 * @return List<Blog>
	 */
	public List<Blog> queryBlog(Blog blog);
	
	/**
	 * 按题目查找博客
	 * @param blog
	 * @return Blog
	 */
	public Blog queryBlogByName(Blog blog);
	
	/**
	 * 分页查找
	 * @param currpage
	 * @param Blog blog
	 * @return PageBean<Blog>
	 */
	public PageBean<Blog> findPageBean(int currpage, Blog blog);

}