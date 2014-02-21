package com.toysforboys.dao;

import javax.persistence.EntityManager;

import com.toysforboys.filters.JPAFilter;


public class AbstractDAO {

	public AbstractDAO() {
		super();
	}

	protected EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}

	public void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	public void commit() {
		getEntityManager().getTransaction().commit();
	}

	public void rollback() {
		getEntityManager().getTransaction().rollback();
	}

}