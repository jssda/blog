package pers.jssd.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService = new UserServiceImp();
	BlogService blogService = new BlogServiceImp();
	TypeService typeService = new TypeServiceImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("loginId");
		User user = new User();
		user.setId(id);
		user = userService.getUser(user);
		request.setAttribute("name", user.getName());
		request.setAttribute("introduction", user.getIntroduction());
		
		String type = request.getParameter("type");
		Blog blog = new Blog();
		Type ty = new Type();
		if(type != null && !type.trim().equals("")) {
			blog.setType(type);
//			ty.setType(type);
		}
		List<Blog> blogList = blogService.queryBlogList(blog);
		List<Type> typeList = typeService.queryTypeList(ty);
		request.setAttribute("blogList", blogList);
		request.setAttribute("typeList", typeList);
		
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
