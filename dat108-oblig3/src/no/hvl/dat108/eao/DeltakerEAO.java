package no.hvl.dat108.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.entities.Deltaker;

/**
 * Klasse for kommunikasjon med database
 * 
 * 
 * @author Gruppe 22
 */
@Stateless
public class DeltakerEAO {
	
	@PersistenceContext(name="deltakerPU")
	private EntityManager em;
	/**
	 * Metode for å finne deltaker med mobilnr i database
	 * 
	 * @param mobil nummer til ønsket deltaker
	 * @return returnerer deltaker knyttet til nummeret som er gitt
	 */
	public Deltaker finnDeltaker(String mobil) {
		Deltaker deltaker = em.find(Deltaker.class, mobil);
		return deltaker;
	}
	/**
	 * Metode for å legge til deltaker i database
	 * 
	 * @param deltaker som vi vil legge til i databasen 
	 */
	public void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
		
	}
	/**
	 * Metode for å finne alle deltakere i databasen
	 * 
	 * @return liste av deltakere
	 */
	public List<Deltaker> finnAlleDeltakere(){
		//Gitt i oppgave at liste skal sorteres stigende pÃ¥ fornavn, deretter etternavn
		List<Deltaker> deltakere = em.createQuery("SELECT d FROM Deltaker d ORDER BY d.fornavn, d.etternavn", Deltaker.class).getResultList();
		return deltakere;
	}
	/**
	 * Metode for å se om delkater finnes i databasen
	 * 
	 * @param mobilnr som skal sjekkes
	 * @return boolean om deltaker finnes eller ikke. 
	 */
	public boolean deltakerFinnes(String mobil) {
		return (finnDeltaker(mobil) != null);
	}

}
