package no.hvl.dat108.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.eao.DeltakerEAO;
import no.hvl.dat108.entities.Deltaker;
import no.hvl.dat108.utils.LoginUtils;

/**
 * Servlet for visning av deltakerliste
 * 
 * @author Gruppe 22
 */
@WebServlet("/DeltakerListeServlet")
public class DeltakerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltakerEAO deltakerEAO;
	private List<Deltaker> liste;
	
	public void init() throws ServletException {
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!LoginUtils.brukerErInnlogget(request)) {
			response.sendRedirect("LoginServlet?trengerLogin");
		} else {
			liste = deltakerEAO.finnAlleDeltakere();
			request.setAttribute("liste",liste);
			request.getRequestDispatcher("WEB-INF/JSP/Deltakerliste.jsp").forward(request, response);
		}	
	}
}
