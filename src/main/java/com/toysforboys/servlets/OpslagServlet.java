package com.toysforboys.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toysforboys.exeptions.WerknemerNietGevondenException;
import com.toysforboys.services.WerknemerService;

/**
 * Servlet implementation class OpslagServlet
 */
@WebServlet("/opslag.htm")
public class OpslagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/opslag.jsp";
	private static final String REDIRECT_URL = "/werknemer.htm";
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WerknemerService werknemerService = new WerknemerService();
		String werknermersNrAlsString = request.getParameter("werknemersNr");
		if (werknermersNrAlsString != null) {
			try {
				Long werknemersNr = Long.valueOf(request
						.getParameter("werknemersNr"));
				request.setAttribute("werknemer",
						werknemerService.read(werknemersNr));

			} catch (NumberFormatException nfex) {
				throw nfex;
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WerknemerService werknemerService = new WerknemerService();
		List<String> fouten = new ArrayList<>();
		BigDecimal opslagBedrag = null;
		Long werknemersNr = Long.parseLong(request.getParameter("werknemersNr"));
		try {
			opslagBedrag = new BigDecimal(request.getParameter("opslagBedrag"));
			if (opslagBedrag.compareTo(BigDecimal.ZERO) <= 0) {
				fouten.add("bedrag moet een positief getal zijn");
			}
		} catch (NumberFormatException ex) {
			fouten.add("bedrag moet een getal zijn");
		}
		if (fouten.isEmpty()) {
			
			try {
				werknemerService.opslag(werknemersNr, opslagBedrag);
			} catch (WerknemerNietGevondenException wngex) {
				fouten.add("Werknemer niet Gevonden");
			}
		} if (fouten.isEmpty()) {
			response.sendRedirect(response.encodeRedirectURL(request
					.getContextPath() + REDIRECT_URL + "?werknemersNr=" + werknemersNr));
		} else {
			String werknermersNrAlsString = request.getParameter("werknemersNr");
			if (werknermersNrAlsString != null) {
				try {
					request.setAttribute("werknemer",
							werknemerService.read(werknemersNr));

				} catch (NumberFormatException nfex) {
					throw nfex;
				}
			}
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
