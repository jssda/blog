/**
 * 
 */
package pers.jssd.blog.service;

import java.util.List;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.bean.PageBean;

/**
 * @author jssd
 *
 */
public interface BlogService {

	/**
	 * 查找文章列表
	 * @param blog
	 * @return List<BlogText>
	 */
	public List<Blog> queryBlogList(Blog blog);
	
	/**
	 * 通过文章标题查找文章
	 * @param blog
	 * @return Blog
	 */
	public Blog queryBlogByName(Blog blog);
	
	/**
	 * @param currpage
	 * @param type
	 * @return PageBean<Blog>
	 */
	public PageBean<Blog> findPageBean(int currpage, String type);
	
	/**
	 * @param blog
	 * @return boolean
	 */
	public boolean updateBlog(Blog blog);
	
}
