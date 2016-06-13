package com.rahmi.BuildCar.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rahmi.BuildCar.model.Car;

@Stateless
public class CarJSPService {
	@PersistenceContext
	EntityManager em;

	public CarJSPService(EntityManager em) {
		this.em = em;
	}

	public CarJSPService() {

	}

	public Car createCar(Car car) {
		em.persist(car);
		return car;
	}

	public Car updateCar(Car car) {
		em.refresh(car);
		return car;
	}

	public List<Car> getAllCar() {
		CriteriaQuery<Car> q = em.getCriteriaBuilder().createQuery(Car.class);
		Root<Car> c = q.from(Car.class);
		q.select(c);
		TypedQuery<Car> query = em.createQuery(q);
		return query.getResultList();
	}

	public Car getById(long id) {
		return em.find(Car.class, id);
	}

	public void flush() {
		em.flush();
	}

	public void deleteCar(Long id) {
		Car car= getById(id);
		if (car == null)
			return;
		em.remove(car);
	}
}
