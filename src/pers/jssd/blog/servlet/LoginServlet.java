/**
 * 
 */
package pers.jssd.blog.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * @author jssd
 *
 */

@WebServlet(name="LoginServlet", urlPatterns="/LoginServlet", description="登陆检查servlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html; charset=utf8");
		UserService userService = new UserServiceImp();
		HttpSession session = req.getSession();
		RequestDispatcher dispatcher = null;
		String sessionValidateCode = (String) session.getAttribute("validateCode");
		
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		String validate = req.getParameter("validate");
		
		if(!sessionValidateCode.equals(validate)) {
			req.setAttribute("username", userName);
			req.setAttribute("errorCode", 0);
			dispatcher = req.getRequestDispatcher("/LoginError.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
		User user = new User();
		user.setName(userName);
		user.setPassword(passWord);
		
		if(userService.checkPassword(user)) {
			session.setAttribute("loginUser", userName);
			dispatcher = req.getRequestDispatcher("/main.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("username", userName);
			req.setAttribute("errorCode", 1);
			dispatcher = req.getRequestDispatcher("/LoginError.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

	
	
}
