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

import com.rahmi.BuildCar.model.CarBody;

public class BodyMapper {
	@PersistenceContext
	private EntityManager em;

	public BodyMapper() {
	}

	public BodyMapper(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Inject
	CarBody body;

	public List<CarBody> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CarBody> q = cb.createQuery(CarBody.class);
		Root<CarBody> c = q.from(CarBody.class);
		q.select(c);
		TypedQuery<CarBody> query = em.createQuery(q);
		return query.getResultList();
	}

	public CarBody getResultByNamedQuery(String queryName, Map<String, Object> items) {
		TypedQuery<CarBody> query = em.createNamedQuery(queryName, CarBody.class);
		for (Entry<String, Object> e : items.entrySet()) {
			query.setParameter(e.getKey(), e.getValue());
		}
		return query.getSingleResult();

	}

	public CarBody getById(long id) {
		return em.find(CarBody.class, id);
	}

	public void persist(CarBody body) {
		em.persist(body);
	}

	public void refresh(CarBody body) {
		em.refresh(body);
	}

	public CarBody save(CarBody body) {
		return em.merge(body);
	}

	public void flush() {
		em.flush();
	}

	public void remove(Long id) {
		CarBody body = getById(id);
		if (body == null)
			return;
		em.remove(body);
	}

}