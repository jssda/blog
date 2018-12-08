package pers.jssd.blog.servlet;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.jssd.blog.bean.User;
import pers.jssd.blog.service.UserService;
import pers.jssd.blog.service.imp.UserServiceImp;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		RequestDispatcher dispatcher = null;
		User user = new User();
		user.setName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		String SAge = request.getParameter("age");
		if(SAge == null || "".equals(SAge)) {
			user.setAge(0);
		} else {
			user.setAge(Integer.parseInt(SAge));
		}
		user.setEmail(request.getParameter("email"));
		user.setTelephone(request.getParameter("telephone"));
		
		boolean signal = false;
		try {
			signal = userService.registerUser(user);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			System.out.println("ceshi");
//			e.printStackTrace();
		}
		
		if(user != null && signal) {
			dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			if(signal == false)
				request.setAttribute("errorCode", 1);
			else		
				request.setAttribute("errorCode", 0);
			dispatcher = request.getRequestDispatcher("/RegisterError.jsp");
			dispatcher.forward(request, response);
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
