package com.rahmi.BuildCar.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rahmi.BuildCar.model.Transmission;



public class TransMapper {
	@PersistenceContext
	private EntityManager em;

	public TransMapper() {

	}

	public TransMapper(EntityManager em) {

		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	

	@Inject
	Transmission transmission;

	public List<Transmission> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Transmission> q = cb.createQuery(Transmission.class);
		Root<Transmission> c = q.from(Transmission.class);
		q.select(c);
		TypedQuery<Transmission> query = em.createQuery(q);
		return query.getResultList();
	}

	public Transmission getResultByNamedQuery(String queryName, Map<String, Object> items) {
		TypedQuery<Transmission> query = em.createNamedQuery(queryName, Transmission.class);
		for (Entry<String, Object> e : items.entrySet()) {
			query.setParameter(e.getKey(), e.getValue());
		}
		return query.getSingleResult();

	}

	public Transmission getById(long id) {
		return em.find(Transmission.class, id);
	}

	public void persist(Transmission transmission) {
		em.persist(transmission);
	}

	public void refresh(Transmission transmission) {
		em.refresh(transmission);
	}

	public Transmission save(Transmission transmission) {
		return em.merge(transmission);
	}

	public void remove(Long id) {
		Transmission transmission = getById(id);
		if (transmission == null)
			return;
		em.remove(transmission);
	}
	
}
