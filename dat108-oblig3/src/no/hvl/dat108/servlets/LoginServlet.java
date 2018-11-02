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
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		String loginBeskjed = LoginUtils.loginOverskrift(request);
		request.setAttribute("beOmPassord", loginBeskjed);
		
		request.getRequestDispatcher("WEB-INF/JSP/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String mobil = request.getParameter("mobil");
		Deltaker deltaker = deltakerEAO.finnDeltaker(mobil);
		if(LoginUtils.loggInn(request,deltaker,timeout)) {
			response.sendRedirect("DeltakerListeServlet");
		}else {
			response.sendRedirect("LoginServlet?feilPassord");
		}
	}
}
