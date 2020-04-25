package controller;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.User;
import models.UserModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		User user= UserModel.getDetails(username);
		if (user!=null&&user.getPassword().equals(password)) {
			Cookie cookie= new Cookie("_username",user.getUsername());
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		}
		request.setAttribute("message", "Incorrect Username or Password!");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
