package com.rahmi.BuildCar.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.rahmi.BuildCar.model.CarBody;

@Stateless
public class CarBodyJSPService {
	@PersistenceContext
	EntityManager em;

	public CarBodyJSPService(EntityManager em) {
		this.em = em;
	}
	public CarBodyJSPService() {
	}

	public CarBody createCarBody(CarBody body) {
		em.persist(body);
		return body;
	}

	public CarBody updateCarBody(CarBody body) {
		em.refresh(body);
		return body;
	}

	public List<CarBody> getAllCarBody() {
		CriteriaQuery<CarBody> q = em.getCriteriaBuilder().createQuery(CarBody.class);
		Root<CarBody> c = q.from(CarBody.class);
		q.select(c);
		TypedQuery<CarBody> query = em.createQuery(q);
		return query.getResultList();
	}

	public CarBody getById(long id) {
		return em.find(CarBody.class, id);
	}

	public void flush() {
		em.flush();
	}

	
	public void deleteCarBody(Long id) {
		CarBody body = getById(id);
		if (body == null)
			return;
		em.remove(body);
	}
}
