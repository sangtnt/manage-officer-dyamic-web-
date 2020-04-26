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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		String fullname=request.getParameter("fullname");
		int age= Integer.parseInt(request.getParameter("age"));
		String sex= request.getParameter("sex");
		String address= request.getParameter("address");
		String job= request.getParameter("job");
		String jobProp= request.getParameter(job);
		Officer officer= new Officer();
		officer.setId(id);
		officer.setFullname(fullname);
		officer.setAge(age);
		officer.setSex(sex);
		officer.setAddress(address);
		officer.setJob(job);
		officer.setJobProp(jobProp);
		if (OfficerModel.updateOfficer(officer)) {
			request.setAttribute("message","updated");
		}
		else {
			request.setAttribute("message","update fail");
		}
		response.sendRedirect("ToHomeServlet");
	}

}
