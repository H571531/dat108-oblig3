package no.hvl.dat108.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.eao.DeltakerEAO;
import no.hvl.dat108.entities.Deltaker;
import no.hvl.dat108.utils.LoginUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	int timeout;
	
	@EJB
	private DeltakerEAO deltakerEAO;
	
	@Override
	public void init() throws ServletException {
		timeout = Integer.parseInt(getServletContext().getInitParameter("timeout"));
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String loginBeskjed = LoginUtils.loginOverskrift(request);
		request.setAttribute("beOmPassord", loginBeskjed);
		
		request.getRequestDispatcher("WEB-INF/JSP/Login.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String mobil = request.getParameter("mobil");
		//String gittPassord = request.getParameter("passord");
		
		Deltaker deltaker = deltakerEAO.finnDeltaker(mobil);
		if(LoginUtils.loggetInn(request,deltaker,timeout)) {
			response.sendRedirect("DeltakerListeServlet");
		}else {
			response.sendRedirect("LoginServlet?feilPassord");
		}
		
		
		
//		if(!LoginUtils.loginOk(request, deltaker)) {
//			response.sendRedirect("LoginServlet?feilPassord");
//			
//		} else {
//			//Forsøk å hente session - hvis den ikke finnes, ikke opprett ny
//			HttpSession sesjon = request.getSession(false);
//			if(sesjon != null) {
//				//hvis session finnes, invalider session
//				sesjon.invalidate();
//			}
//			
//			//Opprett ny session
//			sesjon = request.getSession(true);
//			
//			//"logg ut" etter antall sekunder gitt i web.xml
//			sesjon.setMaxInactiveInterval(timeout);
//			
//			//Send videre mobilnummer
//			sesjon.setAttribute("mobil", mobil);
//			
//			
//			//Send videre til DeltakerListeServlet
//			response.sendRedirect("DeltakerListeServlet");
//		}
		
		
	}

}
