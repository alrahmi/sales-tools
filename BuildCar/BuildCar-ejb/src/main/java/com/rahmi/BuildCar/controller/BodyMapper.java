package com.rahmi.BuildCar.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rahmi.BuildCar.model.CarBody;
import com.rahmi.BuildCar.util.filter.CarBodyRequestForm;
import com.rahmi.BuildCar.util.filter.RequestForm;
import com.rahmi.BuildCar.util.filter.Sort;
import com.rahmi.BuildCar.util.filter.Sort.orderType;

@Stateless
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

	public List<CarBody> getAll(CarBodyRequestForm form) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CarBody> q = cb.createQuery(CarBody.class);
		Root<CarBody> c = q.from(CarBody.class);
		q.select(c);
		if (form != null) {
			if (form.getCountOfDoors() != null) {
				q.where(c.get("countOfDoors").in(form.getCountOfDoors()));
			}
			if (form.getColor() != null) {
				q.where(c.get("color").in(form.getColor()));
			}
			if (form.getType() != null) {
				q.where(c.get("type").in(form.getType()));
			}
			if (form.getVin() != null) {
				q.where(c.get("vin").in(form.getVin()));
			}
			Sort sort = form.getSort();
			if (sort != null) {
				if (sort.getOrderType().equals(orderType.ASC)) {

					q.orderBy(cb.asc(c.get(sort.getName())));

				} else {
					q.orderBy(cb.desc(c.get(sort.getName())));
				}
			}
		}
		TypedQuery<CarBody> query = em.createQuery(q);
		if (form != null && form.getPage() > 0 && form.getLimit() != -1) {
			int start = form.getPage() - 1;

			start = start * form.getLimit();

			query.setFirstResult(start);
			query.setMaxResults(form.getLimit());
		}

		return query.getResultList();
	}

	public List<CarBody> getResultByNamedQuery(String queryName, Map<String, Object> items) {
		TypedQuery<CarBody> query = em.createNamedQuery(queryName, CarBody.class);
		for (Entry<String, Object> e : items.entrySet()) {
			query.setParameter(e.getKey(), e.getValue());
		}
		return query.getResultList();

	}

	public CarBody getById(Long id) {
		return em.find(CarBody.class, id);
	}

	public void create(CarBody body) {
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

	public CarBody update(Long id, CarBody newCarBody) {
		CarBody body = getById(id);
		if (body == null)
			return null;
		body.setType(newCarBody.getType());
		body.setColor(newCarBody.getColor());
		body.setCountOfDoors(newCarBody.getCountOfDoors());
		body.setVIN(newCarBody.getVIN());
		save(body);
		return body;
		
	}

}