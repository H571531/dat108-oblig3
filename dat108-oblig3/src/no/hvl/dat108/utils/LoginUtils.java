package no.hvl.dat108.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltaker;
import no.hvl.dat108.utils.PassordUtil;

public class LoginUtils {

	public static String loginOverskrift(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String beOmPassord = "";
		
		String feilPassord = request.getParameter("feilPassord");
		
		if(feilPassord != null){
			//Hvis bruker ble redirected tilbake på grunn av feil passord
			beOmPassord = "Feil brukernavn/passord. Prøv igjen";
		}
		
		String kreverLogin = request.getParameter("trengerLogin");
		if(kreverLogin != null) {
			//Hvis ble redirected tilbake på grunn av session timeout
			beOmPassord = "Denne handlingen krever at du logger inn";
		}
		
		return beOmPassord;
	}

	public static boolean loginOk(HttpServletRequest request, Deltaker deltaker) {
		if(deltaker == null) {
			return false;
		}
		
		//String mobil = request.getParameter("mobil");
		
		
		//Funnet en eksisterende bruker => sjekk passord
		String gittPassord = request.getParameter("passord");
		if(gittPassord == null) {
			return false;
		}
		
		return PassordUtil.sjekkPassord(gittPassord, deltaker.getHashetPassord());
		
	}
	
	public static boolean brukerErInnlogget(HttpServletRequest request) {
		
		HttpSession sesjon = request.getSession(false);
		
		return !(sesjon == null || sesjon.getAttribute("mobil") == null);
		
	}

}
