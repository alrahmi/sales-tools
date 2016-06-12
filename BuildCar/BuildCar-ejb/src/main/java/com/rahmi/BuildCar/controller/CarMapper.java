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
import com.rahmi.BuildCar.model.Car;


public class CarMapper {
	@PersistenceContext
	private EntityManager em;

	public CarMapper() {
	}

	public CarMapper(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Inject
	Car car;

	public List<Car> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Car> q = cb.createQuery(Car.class);
		Root<Car> c = q.from(Car.class);
		q.select(c);
		TypedQuery<Car> query = em.createQuery(q);
		return query.getResultList();
	}

	public Car getResultByNamedQuery(String queryName, Map<String, Object> items) {
		TypedQuery<Car> query = em.createNamedQuery(queryName, Car.class);
		for (Entry<String, Object> e : items.entrySet()) {
			query.setParameter(e.getKey(), e.getValue());
		}
		return query.getSingleResult();

	}

	public Car getById(long id) {
		return em.find(Car.class, id);
	}

	public void persist(Car car) {
		em.persist(car);
	}

	public void refresh(Car car) {
		em.refresh(car);
	}

	public Car save(Car car) {
		return getEm().merge(car);
	}

	public void flush() {
		getEm().flush();
	}

	public void remove(Long id) {
		Car car = getById(id);
		if (car == null)
			return;
		em.remove(car);
	}
}
