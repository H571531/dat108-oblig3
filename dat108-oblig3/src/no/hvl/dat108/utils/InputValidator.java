package no.hvl.dat108.utils;
/**
 * Hjelpeklasse for � sjekke validering
 * 
 * @author Gruppe 22
 */
public class InputValidator {
	
	

	/**
	 * Sjekker om fornavn er gyldig
	 * 
	 * @return bolsk verdi om det er gyldig
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
	 * @return bolsk verdi om det er gyldig
	 */
	public static boolean isEtternavnGyldig(String navn) {
		if(navn == null) {
			return false;
		}
		return navn.matches("[A-ZÆØÅ][a-zA-ZæøåÆØÅ]{1,19}");
	}

	/**
	 * Sjekker om oppgitt mobilnummeret er gyldig
	 * 
	 * @param mobil
	 * @return bolsk verdi om det er gyldig
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
 * @return bolsk verdi om det er gyldig
 */
	public static boolean isKjonnGyldig(String kjonn) {
		
		return kjonn != null;
	}

	/**
	 * Sjekker om oppgitt passord er gyldig
	 * 
	 * @param passord
	 * @return bolsk verdi om det er gyldig
	 */
	public static boolean isPassordGyldig(String passord) {
	
		return (passord != null) && passord.matches(".{4,}");
	}

}
