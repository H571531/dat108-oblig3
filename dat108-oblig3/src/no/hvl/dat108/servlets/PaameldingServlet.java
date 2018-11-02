package no.hvl.dat108.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.beans.Skjema;
import no.hvl.dat108.eao.DeltakerEAO;
import no.hvl.dat108.entities.Deltaker;
import no.hvl.dat108.utils.LoginUtils;


/**
 * Servlet implementation class PaameldingServlet
 * 
 * @author Gruppe 22
 */
@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@EJB
	private DeltakerEAO deltakerEAO;
	
	private int timeout;
	
	@Override
	public void init() throws ServletException {
		timeout = Integer.parseInt(getServletContext().getInitParameter("timeout"));
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("WEB-INF/JSP/Paamelding.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Skjema skjema = new Skjema(request, deltakerEAO);
		
		
		
		
		if(skjema.isAltGyldig(deltakerEAO)) {
			request.getSession().removeAttribute("skjema");
			
			Deltaker deltaker = skjema.lagDeltaker();
			
			
			deltakerEAO.leggTilDeltaker(deltaker);
			
			LoginUtils.sessionStart(request, deltaker, timeout);
			request.setAttribute("bekreftet", deltaker);
			
			request.getRequestDispatcher("WEB-INF/JSP/Bekreftelse.jsp").forward(request, response);
		} else {
			skjema.setupFeilMeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("PaameldingServlet");
		}		
	}
}
