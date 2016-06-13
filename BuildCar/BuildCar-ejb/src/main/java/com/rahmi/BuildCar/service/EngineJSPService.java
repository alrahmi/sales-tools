package com.rahmi.BuildCar.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rahmi.BuildCar.model.Engine;

//The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class EngineJSPService {
	@PersistenceContext
	EntityManager em;

	public EngineJSPService() {

	}

	public EngineJSPService(EntityManager em) {
		this.em = em;
	}

	public Engine createEngine(Engine engine) {
		em.persist(engine);
		return engine;
	}

	public Engine updateEngine(Engine engine) {
		em.refresh(engine);
		return engine;
	}

	public List<Engine> getAllEngine() {
		CriteriaQuery<Engine> q = em.getCriteriaBuilder().createQuery(Engine.class);
		Root<Engine> c = q.from(Engine.class);
		q.select(c);
		TypedQuery<Engine> query = em.createQuery(q);
		return query.getResultList();
	}

	public Engine getById(long id) {
		return em.find(Engine.class, id);
	}

	public void flush() {
		em.flush();
	}

	public void deleteEngine(Long id) {

		Engine engine = getById(id);
		if (engine == null)
			return;
		em.remove(engine);
	}
}
