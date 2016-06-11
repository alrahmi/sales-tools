package com.rahmi.BuildCar.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DataPersistence {
	@PersistenceContext
	private EntityManager em;

	public DataPersistence() {

	}

	public DataPersistence(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}
}
