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
		Cookie cookie=null;
		Cookie[] cookies=request.getCookies();
		User user=null;
		for (int i=0; i<cookies.length; i++) {
			cookie=cookies[i];
			if (cookie.getName().equals("_username")) {
				user= UserModel.getDetails(cookie.getValue());
				if (user!=null) {
					request.getRequestDispatcher("/ToHomeServlet").forward(request, response);
					return;
				}
			}
		}
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
}
