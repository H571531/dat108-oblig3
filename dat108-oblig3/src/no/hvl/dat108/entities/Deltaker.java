package no.hvl.dat108.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="dat108_oblig3", name="deltaker")
public class Deltaker {
	
	@Id
	private String mobil;
	
	private String hashetPassord;
	private String fornavn;
	private String etternavn;
	private String kjonn;
	

	public Deltaker(String mobil, String passordHash, String fornavn, String etternavn, String kjonn) {
		this.mobil = mobil;
		this.hashetPassord = passordHash;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;

		
		
	
	}
	
	public Deltaker() {
		
	}


	public String getMobil() {
		return mobil;
	}


	public String getHashetPassord() {
		return hashetPassord;
	}


	public String getFornavn() {
		return fornavn;
	}


	public String getEtternavn() {
		return etternavn;
	}


	public String getKjonn() {
		return kjonn;
	}

	
	
}
