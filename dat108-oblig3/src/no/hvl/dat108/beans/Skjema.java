package no.hvl.dat108.beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.text.StringEscapeUtils;

import no.hvl.dat108.eao.DeltakerEAO;
import no.hvl.dat108.entities.Deltaker;
import no.hvl.dat108.utils.InputValidator;
import no.hvl.dat108.utils.PassordUtil;

/**
 * 
 * @author Gruppe 22
 * 
 * Form bean for å håndtere påmeldingsskjema
 *
 */
public class Skjema {
	
	private String fornavn;
	private String fornavnFeilmelding;
	private String etternavn;
	private String etternavnFeilmelding;
	private String mobil;
	private String mobilFeilmelding;
	private String passord;
	private String passordFeilmelding;
	private String passordRepetert;
	private String passordRepetertFeilmelding;
	private String kjonn;
	private String kjonnFeilmelding;
	
	private DeltakerEAO deltakerEAO;
	
	
	
	

	public Skjema(HttpServletRequest request, DeltakerEAO deltakerEAO) {
		
		this.fornavn = StringEscapeUtils.escapeHtml4(request.getParameter("fornavn"));
		this.etternavn = StringEscapeUtils.escapeHtml4(request.getParameter("etternavn"));
		this.mobil = StringEscapeUtils.escapeHtml4(request.getParameter("mobil"));
		this.passord = request.getParameter("passord");
		this.passordRepetert = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
		this.deltakerEAO = deltakerEAO;
		
	}
	
	public boolean isAltGyldig(DeltakerEAO eao) {
		
		//Validering av skjema gjøres i javascript i klient - gjør også på server
		return isFornavnGyldig() && isEtternavnGyldig() && isMobilGyldig() && isIkkeTidligereRegistrert() && isPassordGyldig() && isPassordLike() && isKjonnGyldig();
	}
	
	private boolean isIkkeTidligereRegistrert() {
		return !deltakerEAO.deltakerFinnes(mobil);
	}

	public boolean isFornavnGyldig() {
		return InputValidator.isFornavnGyldig(fornavn);
		
	}
	

	private boolean isEtternavnGyldig() {
		return InputValidator.isEtternavnGyldig(etternavn);
	}
	
	private boolean isMobilGyldig() {
		return InputValidator.isMobilGyldig(mobil);
	}
	
	private boolean isPassordGyldig() {
		return InputValidator.isPassordGyldig(passord) ;
	}
	
	private boolean isPassordLike() {
		if(passord == null || passordRepetert == null) {
			return false;
		}
		return passord.equals(passordRepetert);
	}

	private boolean isKjonnGyldig() {
		return InputValidator.isKjonnGyldig(kjonn);
	}

	

	public void setupFeilMeldinger() {
		if(!isFornavnGyldig()) {
			fornavn = "";
			fornavnFeilmelding = "Ugyldig fornavn!";
		}
		if(!isEtternavnGyldig()) {
			etternavn = "";
			etternavnFeilmelding = "Ugyldig etternavn!";
		}
		if(!isMobilGyldig() || !isIkkeTidligereRegistrert()) {
			mobil = "";
			mobilFeilmelding = "Ugyldig mobil!";
		}
		if(!isKjonnGyldig()) {
			kjonn = "";
			kjonnFeilmelding ="Kj&oslash;nn ikke valgt!";
		}
		if(!isPassordGyldig()) {
			passordFeilmelding = "Ugyldig passord!";
		}
		if(!isPassordLike()) {
			passordRepetertFeilmelding = "Passordene m&aring; v&aelig; like!";
		}
		//TODO: kjÃ¸nn, passord
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getFornavnFeilmelding() {
		return fornavnFeilmelding;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getEtternavnFeilmelding() {
		return etternavnFeilmelding;
	}

	public String getMobil() {
		return mobil;
	}

	public String getMobilFeilmelding() {
		return mobilFeilmelding;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordFeilmelding() {
		return passordFeilmelding;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public String getPassordRepetertFeilmelding() {
		return passordRepetertFeilmelding;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getKjonnFeilmelding() {
		return kjonnFeilmelding;
	}

	public Deltaker lagDeltaker() {
		Deltaker ny = new Deltaker(mobil, PassordUtil.krypterPassord(passord), fornavn,  etternavn, kjonn);
		return ny;
	}

	

}
