package no.hvl.dat108.utils;
/**
 * Hjelpeklasse for � sjekke validering
 * 
 * Gitt i oppgave: 
 * Fornavn mellom 2-20 tegn, kan inneholde bokstaver, bindestrek og mellomrom, f�rste tegn skal v�re stor bokstav, 
 * Etternavn 2-20 tegn, kan inneholde bokstaver og bindestrek, f�rste tegn skal v�re stor bokstav
 * Mobil eksakt 8 siffer, skal v�re unikt (sjekkes p� server)
 * Passord skal ha en minimumslengde (her satt til 4 tegn)
 * Repetert passord m� v�re likt passord
 * 
 * Validering av skjema gj�res ogs� i javascript i klient
 * 
 * @author Gruppe 22
 */
public class InputValidator {
	
	

	/**
	 * Sjekker om fornavn er gyldig
	 * 
	 * @return boolsk verdi om det er gyldig
	 */
	public static boolean isFornavnGyldig(String navn) {
		// TODO Auto-generated method stub
		if(navn == null) {
			return false;
		}
		return navn.matches("^[A-Z���]([- ]*[a-zA-Z������]){1,19}$");
	}
	/**
	 * Sjekker om etternavn er gyldig
	 * 
	 * @param navn
	 * @return boolsk verdi om det er gyldig
	 */
	public static boolean isEtternavnGyldig(String navn) {
		if(navn == null) {
			return false;
		}
		return navn.matches("[A-Z���]([-]*[a-zA-Z������]){1,19}");
	}

	/**
	 * Sjekker om oppgitt mobilnummeret er gyldig
	 * 
	 * @param mobil
	 * @return boolsk verdi om det er gyldig
	 */
	public static boolean isMobilGyldig(String mobil) {
		if(mobil == null) {
			return false;
		}
		return mobil.matches("[0-9]{8}");
	}
/**
 * Sjekker om oppgitt kj�nn er gyldig
 * 
 * @param kjonn
 * @return boolsk verdi om det er gyldig
 */
	public static boolean isKjonnGyldig(String kjonn) {
		
		return kjonn != null;
	}

	/**
	 * Sjekker om oppgitt passord er gyldig
	 * 
	 * @param passord
	 * @return boolsk verdi om det er gyldig
	 */
	public static boolean isPassordGyldig(String passord) {
	
		return (passord != null) && passord.matches(".{4,}");
	}

}
