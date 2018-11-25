package pers.jssd.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.service.UserService;
import pers.jssd.blog.service.imp.UserServiceImp;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String introduction = request.getParameter("introduction");
		User user = new User();
		user.setId(userId);
		user.setName(name);
		user.setPassword(password);
		user.setGender(gender);
		user.setAge(age);
		user.setTelephone(telephone);
		user.setEmail(email);
		user.setIntroduction(introduction);
		if(userService.modifyUser(user)) {
			System.out.println("aaa");
			request.getRequestDispatcher("/MainServlet").forward(request, response);;
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);;
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
