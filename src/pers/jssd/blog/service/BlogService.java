/**
 * 
 */
package pers.jssd.blog.service;

import java.util.List;

import pers.jssd.blog.bean.Blog;

/**
 * @author jssd
 *
 */
public interface BlogService {

	/**
	 * @param blog
	 * @return List<BlogText>
	 */
	public List<Blog> queryBlogList(Blog blog);
	
}
