package com.rahmi.BuildCar.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.rahmi.BuildCar.model.Transmission;

@Stateless
public class TransmissionJSPService {

	@PersistenceContext
	EntityManager em;

	public TransmissionJSPService(EntityManager em) {
		this.em = em;
	}

	public TransmissionJSPService() {
	}

	public Transmission createTransmission(Transmission transmission) {
		em.persist(transmission);
		return transmission;
	}

	public Transmission updateTransmission(Transmission transmission) {
		em.refresh(transmission);
		return transmission;
	}

	public List<Transmission> getAllTransmission() {
		CriteriaQuery<Transmission> q = em.getCriteriaBuilder().createQuery(Transmission.class);
		Root<Transmission> c = q.from(Transmission.class);
		q.select(c);
		TypedQuery<Transmission> query = em.createQuery(q);
		return query.getResultList();
	}

	public Transmission getById(long id) {
		return em.find(Transmission.class, id);
	}

	public void flush() {
		em.flush();
	}

	public void deleteTransmission(Long id) {
		Transmission transmission = getById(id);
		if (transmission == null)
			return;
		em.remove(transmission);
	}

}
