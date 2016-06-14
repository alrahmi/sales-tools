package com.rahmi.BuildCar.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.rahmi.BuildCar.model.Transmission;
import com.rahmi.BuildCar.util.filter.Sort;
import com.rahmi.BuildCar.util.filter.Sort.orderType;
import com.rahmi.BuildCar.util.filter.TransmissionRequestForm;

@Stateless
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

	public List<Transmission> getAll(TransmissionRequestForm form) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Transmission> q = cb.createQuery(Transmission.class);
		Root<Transmission> c = q.from(Transmission.class);
		q.select(c);
		if (form != null) {
			if (form.getType() != null) {
				q.where(c.get("type").in(form.getType()));
			}
			if (form.getSerialNumber() != null) {
				q.where(c.get("type").in(form.getSerialNumber()));
			}
		}
		TypedQuery<Transmission> query = em.createQuery(q);
		Sort sort = form.getSort();
		if (sort != null) {
			if (sort.getOrderType().equals(orderType.ASC)) {

				q.orderBy(cb.asc(c.get(sort.getName())));

			} else {
				q.orderBy(cb.desc(c.get(sort.getName())));
			}
		}
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

	public void create(Transmission transmission) {
		em.persist(transmission);
	}

	public void refresh(Transmission transmission) {
		em.refresh(transmission);
	}

	public Transmission save(Transmission transmission) {
		return em.merge(transmission);
	}

	public void flush() {
		em.flush();
	}

	public void remove(Long id) {
		Transmission transmission = getById(id);
		if (transmission == null)
			return;
		em.remove(transmission);
	}

	public Transmission update(Long id, Transmission newTransmission) {
		Transmission transmission = getById(id);
		if (transmission == null) {
			return null;
		}
		transmission.setType(newTransmission.getType());
		transmission.setSerialNumber(newTransmission.getSerialNumber());
		save(transmission);
		return transmission;
	}

}
