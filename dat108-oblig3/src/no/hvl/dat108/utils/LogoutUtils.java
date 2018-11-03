package no.hvl.dat108.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Hjelpeklasse for utlogging
 * 
 * 
 * @author Gruppe 22
 */
public class LogoutUtils {

	/**
	 * Logger ut en bruker
	 * @param request Request fra bruker
	 */
	public static void logout(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
        	sesjon.removeAttribute("mobil");
            sesjon.invalidate();
        }
	}
}
