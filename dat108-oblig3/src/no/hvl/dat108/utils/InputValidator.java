package no.hvl.dat108.utils;

public class InputValidator {
	
	

	/**
	 * 
	 * @return
	 */
	public static boolean isFornavnGyldig(String navn) {
		// TODO Auto-generated method stub
		if(navn == null) {
			return false;
		}
		return navn.matches("^[A-ZÆØÅ]([- ]*[a-zA-ZæøåÆØÅ]){1,19}$");
	}
	
	public static boolean isEtternavnGyldig(String navn) {
		if(navn == null) {
			return false;
		}
		return navn.matches("[A-ZÆØÅ][a-zA-ZæøåÆØÅ]{1,19}");
	}

	public static boolean isMobilGyldig(String mobil) {
		if(mobil == null) {
			return false;
		}
		return mobil.matches("[0-9]{8}");
	}

	public static boolean isKjonnGyldig(String kjonn) {
		
		return kjonn != null;
	}

	public static boolean isPassordGyldig(String passord) {
	
		return (passord != null) && passord.matches(".{4,}");
	}

}
