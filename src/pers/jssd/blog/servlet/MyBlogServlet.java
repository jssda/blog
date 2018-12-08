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
import pers.jssd.blog.bean.PageBean;
import pers.jssd.blog.bean.Type;
import pers.jssd.blog.bean.User;
import pers.jssd.blog.service.BlogService;
import pers.jssd.blog.service.TypeService;
import pers.jssd.blog.service.UserService;
import pers.jssd.blog.service.imp.BlogServiceImp;
import pers.jssd.blog.service.imp.TypeServiceImp;
import pers.jssd.blog.service.imp.UserServiceImp;

/**
 * Servlet implementation class MyBlogServlet
 */
@WebServlet("/MyBlogServlet")
public class MyBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserService userService = new UserServiceImp();
	BlogService blogService = new BlogServiceImp();
	TypeService typeService = new TypeServiceImp();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBlogServlet() {
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
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("loginId");
		User user = new User();
		user.setId(userId);
		user = userService.getUser(user);
		
		Blog blog = new Blog();
		blog.setAuthor(user.getName());
		String type = request.getParameter("type");
		Type ty = new Type();
		if(type != null && !type.trim().equals("") && !type.trim().equals("null")) {
			blog.setType(type);
		} else {
			type = null;
		}
		int currPage = 1;
		String strCurrPage = request.getParameter("currPage");
		if(strCurrPage != null && !strCurrPage.trim().equals("")) {
			currPage = Integer.parseInt(strCurrPage);
		}
		PageBean<Blog> pageBean = blogService.findPageBean(currPage, blog);
		List<Type> typeList = typeService.queryTypeList(ty);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("typeList", typeList);
		
		List<Blog> list = blogService.queryBlogList(blog);
		request.setAttribute("blogList", list);
		request.getRequestDispatcher("/myblog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
