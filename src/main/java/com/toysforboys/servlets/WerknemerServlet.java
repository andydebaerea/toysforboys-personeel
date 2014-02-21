package com.toysforboys.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toysforboys.services.WerknemerService;

@WebServlet("/werknemer.htm")
public class WerknemerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/werknemer.jsp";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WerknemerService werknemerService = new WerknemerService();
		if (!request.getParameterMap().isEmpty()) {
			String werknermersNrAlsString = request
					.getParameter("werknemersNr");
			if (werknermersNrAlsString != null) {
				try {
					Long werknemersNr = Long.valueOf(request
							.getParameter("werknemersNr"));
					request.setAttribute("werknemer", werknemerService.read(werknemersNr));

				} catch (NumberFormatException nfex) {
					throw nfex;
				}
			}
		} else {
			request.setAttribute("werknemer", werknemerService.findByJobTitelNr());
		}

		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
