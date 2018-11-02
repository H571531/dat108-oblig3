package no.hvl.dat108.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.entities.Deltaker;


@Stateless
public class DeltakerEAO {
	
	@PersistenceContext(name="deltakerPU")
	private EntityManager em;

	public Deltaker finnDeltaker(String mobil) {
		Deltaker deltaker = em.find(Deltaker.class, mobil);
		return deltaker;
	}
	
	public void leggTilDeltaker(Deltaker deltaker) {
		em.persist(deltaker);
		
	}
	
	public List<Deltaker> finnAlleDeltakere(){
		//Gitt i oppgave at liste skal sorteres stigende på fornavn, deretter etternavn
		List<Deltaker> deltakere = em.createQuery("SELECT d FROM Deltaker d ORDER BY d.fornavn, d.etternavn", Deltaker.class).getResultList();
		return deltakere;
	}
	
	public boolean deltakerFinnes(String mobil) {
		return (finnDeltaker(mobil) != null);
	}

}
