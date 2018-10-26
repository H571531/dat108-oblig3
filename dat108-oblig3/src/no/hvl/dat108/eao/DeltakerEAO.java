package no.hvl.dat108.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat108.entities.Deltaker;


@Stateless
public class DeltakerEAO {
	@PersistenceContext(name="DeltakerPU")
	private EntityManager em;
	
	public List<Deltaker> hentAlle(){
		return em.createQuery("SELECT v FROM deltaker v", Deltaker.class).getResultList();
	}

	public void leggTil(Deltaker d) {
			em.persist(d);
		
	}
	
}
