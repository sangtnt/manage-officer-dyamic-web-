package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Officer;
import models.OfficerModel;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname= request.getParameter("fullname");
		int age=Integer.parseInt(request.getParameter("age"));
		String sex= request.getParameter("sex");
		String address= request.getParameter("address");
		String job= request.getParameter("job");
		String jobProp= request.getParameter(job);
		Officer officer= new Officer();
		officer.setId(0);
		officer.setFullname(fullname);
		officer.setAge(age);
		officer.setAddress(address);
		officer.setSex(sex);
		officer.setJob(job);
		officer.setJobProp(jobProp);
		if (OfficerModel.add(officer)) {
			request.setAttribute("message", "add successfully!");
		}
		else {
			request.setAttribute("message", "add officer fail!");
		}
		response.sendRedirect("ToHomeServlet");
	}

}
