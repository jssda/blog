/**
 * 
 */
package pers.jssd.blog.service.imp;

import java.util.List;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.dao.BlogDao;
import pers.jssd.blog.dao.Imp.BlogDaoImp;
import pers.jssd.blog.service.BlogService;

/**
 * @author jssd
 *
 */
public class BlogServiceImp implements BlogService {

	BlogDao blogDao = new BlogDaoImp();
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.BlogService#queryBlogList(pers.jssd.blog.bean.BlogText)
	 */
	@Override
	public List<Blog> queryBlogList(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.queryBlog(blog);
	}

}
