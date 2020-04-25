package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.User;
import models.UserModel;

/**
 * Servlet implementation class CheckCookie
 */
@WebServlet("/CheckCookie")
public class CheckCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie: cookies) {
			String username=cookie.getName();
			if (username.equals("_username")) {
				User user= UserModel.getDetails(username);
				if (user!=null) {
					request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
				}
			}
		}
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}
}
