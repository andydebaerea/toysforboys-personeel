package com.toysforboys.dao;

import javax.persistence.TypedQuery;

import com.toysforboys.entities.JobTitel;

public class JobTitelDAO extends AbstractDAO {
	public Iterable<JobTitel> findall() {
		TypedQuery<JobTitel> query = getEntityManager().createNamedQuery(
				"jobtitels.findAll", JobTitel.class);
		return query.getResultList();
	}
	
	public JobTitel read(Long jobTitelNr) {
		return getEntityManager().find(JobTitel.class, jobTitelNr);
	}
}
