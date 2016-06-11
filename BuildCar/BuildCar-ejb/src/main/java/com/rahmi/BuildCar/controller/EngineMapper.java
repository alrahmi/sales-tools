package com.rahmi.BuildCar.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rahmi.BuildCar.model.Engine;

public class EngineMapper {
	@PersistenceContext
	private EntityManager em;

	public EngineMapper() {
	}

	public EngineMapper(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Inject
	Engine engine;

	public List<Engine> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Engine> q = cb.createQuery(Engine.class);
		Root<Engine> c = q.from(Engine.class);
		q.select(c);
		TypedQuery<Engine> query = em.createQuery(q);
		return query.getResultList();
	}

	public Engine getResultByNamedQuery(String queryName, Map<String, Object> items) {
		TypedQuery<Engine> query = em.createNamedQuery(queryName, Engine.class);
		for (Entry<String, Object> e : items.entrySet()) {
			query.setParameter(e.getKey(), e.getValue());
		}
		return query.getSingleResult();

	}

	public Engine getById(long id) {
		return em.find(Engine.class, id);
	}

	public void persist(Engine engine) {
		em.persist(engine);
	}

	public void refresh(Engine engine) {
		em.refresh(engine);
	}

	public Engine save(Engine engine) {
		return getEm().merge(engine);
	}

	public void flush() {
		getEm().flush();
	}

	public void remove(Long id) {
		Engine engine = getById(id);
		if (engine == null)
			return;
		em.remove(engine);
	}
}
