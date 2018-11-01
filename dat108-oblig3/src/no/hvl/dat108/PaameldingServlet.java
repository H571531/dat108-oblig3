package no.hvl.dat108;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.eao.DeltakerEAO;


/**
 * Servlet implementation class PaameldingServlet
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("WEB-INF/JSP/Paamelding.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Skjema skjema = new Skjema(request, deltakerEAO);
		
		
		
		
		if(skjema.isAltGyldig(deltakerEAO)) {
			request.getSession().removeAttribute("skjema");
			//TODO: opprette person, legge til db, legge til response? session?
			
			Deltaker deltaker = skjema.lagDeltaker();
			
			//liste.add(deltaker);
			
			deltakerEAO.leggTilDeltaker(deltaker);
			
			request.getSession().setAttribute("mobil", deltaker.getMobil());
			request.getSession().setMaxInactiveInterval(timeout);
			request.setAttribute("bekreftet", deltaker);
			
			request.getRequestDispatcher("WEB-INF/JSP/Bekreftelse.jsp").forward(request, response);
			//response.sendRedirect("WEB-INF/JSP/Bekreftelse.jsp");
		} else {
			skjema.setupFeilMeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("PaameldingServlet");
		}
		
		
	}

}
