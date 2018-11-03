package no.hvl.dat108.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Klasse for deltaker objektet
 * 
 * @author Gruppe22
 */
@Entity
@Table(schema="dat108_oblig3", name="deltaker")
public class Deltaker {
	
	@Id
	private String mobil;
	
	private String hashetPassord;
	private String fornavn;
	private String etternavn;
	private String kjonn;
	
/**
 * Konstruktør
 * 
 * @param mobil
 * @param passordHash
 * @param fornavn
 * @param etternavn
 * @param kjonn
 */
	public Deltaker(String mobil, String passordHash, String fornavn, String etternavn, String kjonn) {
		this.mobil = mobil;
		this.hashetPassord = passordHash;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;

		
		
	
	}
	/**
	 * Default konstruktør, trengs for JPA
	 */
	public Deltaker() {
		
	}

	/**
	 * Hent mobilnr fra objektet
	 * 
	 * @return mobilnr til objektet
	 */
	public String getMobil() {
		return mobil;
	}

	/**
	 * Hent HashetPassord fra objektet
	 * 
	 * @return HashetPassord til objektet
	 */
	public String getHashetPassord() {
		return hashetPassord;
	}

	/**
	 * Hent Fornavn fra objektet
	 * 
	 * @return Fornavn til objektet
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * Hent Etternavn fra objektet
	 * 
	 * @return Etternavn til objektet
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * Hent kjønnet fra objektet
	 * 
	 * @return kjønnet til objektet
	 */
	public String getKjonn() {
		return kjonn;
	}

	
	
}
