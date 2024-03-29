package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Officer;
import models.OfficerModel;

/**
 * Servlet implementation class TOHomeServlet
 */
@WebServlet("/ToHomeServlet")
public class ToHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Officer> officers= OfficerModel.getFull();
		request.setAttribute("officers", officers);
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
