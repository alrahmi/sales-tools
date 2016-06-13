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

import com.rahmi.BuildCar.model.Engine;
import com.rahmi.BuildCar.util.filter.EngineRequestForm;
import com.rahmi.BuildCar.util.filter.Sort;
import com.rahmi.BuildCar.util.filter.Sort.orderType;

@Stateless
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

	public List<Engine> getAll(EngineRequestForm form) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Engine> q = cb.createQuery(Engine.class);
		Root<Engine> c = q.from(Engine.class);
		q.select(c);
		if (form != null) {
			if (form.getType() != null) {
				q.where(c.get("type").in(form.getType()));
			}
			if (form.getPower() != null) {
				q.where(c.get("power").in(form.getPower()));
			}
			if (form.getSerialNumber() != null) {
				q.where(c.get("serialNumber").in(form.getSerialNumber()));
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
		TypedQuery<Engine> query = em.createQuery(q);
		if (form != null && form.getPage() > 0 && form.getLimit() != -1) {
			int start = form.getPage() - 1;
			start = start * form.getLimit();
			query.setFirstResult(start);
			query.setMaxResults(form.getLimit());
		}
		return query.getResultList();
	}

	public Engine getOneResult(String queryName, Map<String, Object> items) {
		TypedQuery<Engine> query = em.createNamedQuery(queryName, Engine.class);
		for (Entry<String, Object> e : items.entrySet()) {
			query.setParameter(e.getKey(), e.getValue());
		}
		return query.getSingleResult();
	}

	public Engine getById(long id) {
		return em.find(Engine.class, id);
	}

	public void create(Engine engine) {
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
