package no.hvl.dat108.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat108.eao.DeltakerEAO;
import no.hvl.dat108.utils.LoginUtils;

/**
 * Servlet for å håndtere innloggingsside
 * 
 * @author Gruppe 22
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
		if(LoginUtils.loggInn(request, timeout, deltakerEAO)) {
			//Alt ok, send videre til DeltakerListeServlet
			response.sendRedirect("DeltakerListeServlet");
		}else {
			response.sendRedirect("LoginServlet?feilPassord");
		}
	}
}
