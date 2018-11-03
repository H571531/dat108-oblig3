package no.hvl.dat108.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.eao.DeltakerEAO;
import no.hvl.dat108.entities.Deltaker;
/**
 * Hjelpeklasse for innlogging
 * 
 * 
 * @author Gruppe 22
 */
public class LoginUtils {
	/**
	 * Klasse for å bestemme overskrift på inlogging
	 * 
	 * @param request fra servlet
	 * @return feilmelding/overskrift i inloggingskjerm
	 */
	public static String loginOverskrift(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String beOmPassord = "";
		
		String feilPassord = request.getParameter("feilPassord");
		
		if(feilPassord != null){
			//Hvis bruker ble redirected tilbake pÃ¥ grunn av feil passord
			beOmPassord = "Feil brukernavn/passord. Pr&oslash;v igjen";
		}
		
		String kreverLogin = request.getParameter("trengerLogin");
		if(kreverLogin != null) {
			//Hvis ble redirected tilbake pÃ¥ grunn av session timeout
			beOmPassord = "Denne handlingen krever at du logger inn";
		}
		
		return beOmPassord;
	}
	
	
/**
 * Metode for å sjekke om en bruker har gitt brukernavn som finnes i databasen og matchende passord
 * 
 * @param deltaker som skal sjekkes om er logget inn
 * @param gittPassord Passord gitt i login-skjema
 * @return boolsk verdi om bruker har gitt korrekte opplysninger
 */
	public static boolean loginOk(Deltaker deltaker, String gittPassord) {
		
		if(deltaker == null || gittPassord == null) {
			return false;
		}
		
		//Funnet en eksisterende bruker => sjekk om gitt passord matcher hashet passord lagret i database
		
		return PassordUtil.sjekkPassord(gittPassord, deltaker.getHashetPassord());
		
	}
	/**
	 * Sjekker om brukeren er logget inn
	 * 
	 * @param request fra servlet
	 * @return sjekker om bruker er logget inn
	 */
	public static boolean brukerErInnlogget(HttpServletRequest request) {
		
		HttpSession sesjon = request.getSession(false);
		
		return !(sesjon == null || sesjon.getAttribute("mobil") == null);
		
	}
	
	/**
	 * Metode som logger bruker inn. 
	 * 
	 * @param request fra servlet
	 * @param deltaker som skal logges inn
	 * @param timeout for sesjon invalidation
	 * @return true hvis bruker har blitt logget inn, false hvis ikke
	 */
	public static boolean loggInn(HttpServletRequest request, int timeout, DeltakerEAO deltakerEAO){
		
		String mobil = request.getParameter("mobil"); //Hent gitt brukernavn fra request
		Deltaker deltaker = deltakerEAO.finnDeltaker(mobil); //Forsøk å hent deltaker fra database med gitt brukernavn
		String passord = request.getParameter("passord"); //Hent gitt passord fra request
		
		if(!LoginUtils.loginOk(deltaker, passord)) {
			//Bruker har gitt ugyldig brukernavn eller passord
			return false;
		} else {
			//Login-opplysninger er ok, opprett session
			sessionStart(request, deltaker, timeout);
			
			return true;
		}
	}

	/**
	 * Metode for å starte en sesjon med deltaker
	 * 
	 * @param request fra servlet
	 * @param deltaker som skal logges inn
	 * @param timeout for invalidation av sesjon
	 */
	public static void sessionStart(HttpServletRequest request, Deltaker deltaker, int timeout) {
		
		//Forsøk å hente session - hvis den ikke finnes, ikke opprett ny
		HttpSession sesjon = request.getSession(false);
		if(sesjon != null) {
			//hvis session finnes, invalider session
			sesjon.invalidate();
		}
		
		//Opprett ny session
		sesjon = request.getSession(true);
		//"logg ut" etter antall sekunder gitt i web.xml
		sesjon.setMaxInactiveInterval(timeout);
		//Send videre mobilnummer som session attribute
		sesjon.setAttribute("mobil", deltaker.getMobil());
	}
}
