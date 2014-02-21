package com.toysforboys.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toysforboys.entities.JobTitel;
import com.toysforboys.services.JobTitelService;

/**
 * Servlet implementation class JobTitelsServlet
 */
@WebServlet("/jobtitels.htm")
public class JobTitelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/jobtitels.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobTitelService jobTitelService = new JobTitelService();
		request.setAttribute("jobTitels", jobTitelService.findAll());
		if (!request.getParameterMap().isEmpty()) {
			String jobTitelNrAlsString = request.getParameter("jobTitelNr");
			if (jobTitelNrAlsString != null) {
				try {
					Long jobTitelNr = Long.valueOf(request.getParameter("jobTitelNr"));
					JobTitel jobTitel = jobTitelService.read(jobTitelNr);
					request.setAttribute("jobTitel", jobTitel);					
				} catch (NumberFormatException nfex) {
					throw nfex;
				}
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
