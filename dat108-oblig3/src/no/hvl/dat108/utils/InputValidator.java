package no.hvl.dat108.utils;
/**
 * Hjelpeklasse for å sjekke validering
 * 
 * Gitt i oppgave: 
 * Fornavn mellom 2-20 tegn, kan inneholde bokstaver, bindestrek og mellomrom, første tegn skal være stor bokstav, 
 * Etternavn 2-20 tegn, kan inneholde bokstaver og bindestrek, første tegn skal være stor bokstav
 * Mobil eksakt 8 siffer, skal være unikt (sjekkes på server)
 * Passord skal ha en minimumslengde (her satt til 4 tegn)
 * Repetert passord må være likt passord
 * 
 * Validering av skjema gjøres også i javascript i klient
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
		return navn.matches("^[A-ZÆØÅ]([- ]*[a-zA-ZæøåÆØÅ]){1,19}$");
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
		return navn.matches("[A-ZÆØÅ]([-]*[a-zA-ZæøåÆØÅ]){1,19}");
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
 * Sjekker om oppgitt kjønn er gyldig
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
