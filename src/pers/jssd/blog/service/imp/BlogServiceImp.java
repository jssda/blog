/**
 * 
 */
package pers.jssd.blog.service.imp;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.bean.PageBean;
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
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.BlogService#queryBlogByName(pers.jssd.blog.bean.Blog)
	 */
	@Override
	public Blog queryBlogByName(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.queryBlogByName(blog);
	}
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.BlogService#findPageBean(int, java.lang.String)
	 */
	@Override
	public PageBean<Blog> findPageBean(int currpage, Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.findPageBean(currpage, blog);
	}
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.BlogService#updateBlog(pers.jssd.blog.bean.Blog)
	 */
	@Override
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.updateBlog(blog);
	}
	/* (non-Javadoc)
	 * @see pers.jssd.blog.service.BlogService#addBlog(pers.jssd.blog.bean.Blog)
	 */
	@Override
	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = blogDao.addBlog(blog);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("博客添加失败");
		}
		return flag;
	}

}
