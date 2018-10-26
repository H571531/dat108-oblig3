package no.hvl.dat108.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "dat108_oblig3", name = "deltaker")
public class Deltaker {
	@Id
	private String mobil;
	
	private String fornavn;
	private String etternavn;
	private String hashetPassord;
	private char kjonn;
	public Deltaker(String mobil, String fornavn, String etternavn, String hashetPassord, char kjonn) {
		super();
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.hashetPassord = hashetPassord;
		this.kjonn = kjonn;
	}
	public String getMobil() {
		return mobil;
	}
	public String getFornavn() {
		return fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public String getHashetPassord() {
		return hashetPassord;
	}
	public char getKjonn() {
		return kjonn;
	}
	@Override
	public String toString() {
		return fornavn+"\n"+etternavn+"\n"+mobil;
	}
	
	
	
}
