package pers.jssd.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.service.BlogService;
import pers.jssd.blog.service.imp.BlogServiceImp;

/**
 * Servlet implementation class ViewBlogServlet
 */
@WebServlet("/ViewBlogServlet")
public class ViewBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BlogService blogService = new BlogServiceImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html; charset=utf8");
		String title = request.getParameter("title");
		Blog blog = new Blog();
		blog.setTitle(title);
		blog = blogService.queryBlogByName(blog);
		if(blog != null) {
			request.setAttribute("blog", blog);
			int visitCount = blog.getVisitCount();
			blog.setVisitCount(++visitCount);
			System.out.println(blog.getVisitCount());
			System.out.println("id = "+blog.getId());
			blogService.updateBlog(blog);
			request.getRequestDispatcher("/viewblog.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
