package pers.jssd.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.jssd.blog.bean.Blog;
import pers.jssd.blog.bean.Type;
import pers.jssd.blog.bean.User;
import pers.jssd.blog.service.BlogService;
import pers.jssd.blog.service.TypeService;
import pers.jssd.blog.service.UserService;
import pers.jssd.blog.service.imp.BlogServiceImp;
import pers.jssd.blog.service.imp.TypeServiceImp;
import pers.jssd.blog.service.imp.UserServiceImp;

/**
 * Servlet implementation class WriteBlogServlet
 */
@WebServlet("/WriteBlogServlet")
public class WriteBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BlogService blogService = new BlogServiceImp();
	TypeService typeService = new TypeServiceImp();
	UserService userService = new UserServiceImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		
		User user = new User();
		int userId = (int) request.getSession().getAttribute("loginId");
		user.setId(userId);
		user = userService.getUser(user);
		
		Blog blog = new Blog();
		String title = request.getParameter("title");
		String t = request.getParameter("type");
		String blogInfo = request.getParameter("textinfo");
		String blogContent = request.getParameter("textcontent");
		blog.setTitle(title);
		blog.setAuthor(user.getName());
		blog.setType(t);
		blog.setInfo(blogInfo);
		blog.setContent(blogContent);
		
		Type type = new Type();
		type.setType(t);
		List<Type> list = typeService.queryTypeList(type);
		if(list.size() != 0) {
			//有此类型
			if(blogService.addBlog(blog)) {
				flag = true;
			} else {
				flag = false;
			}
		} else {
			if(!typeService.addType(type)) {
				System.out.println("添加类型失败");
			} else {
				if(blogService.addBlog(blog)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		
		if(flag) {
			request.getRequestDispatcher("/MainServlet").forward(request, response);;
		} else {
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
