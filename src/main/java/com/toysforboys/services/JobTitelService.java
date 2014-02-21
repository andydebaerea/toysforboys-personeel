package com.toysforboys.services;

import com.toysforboys.dao.JobTitelDAO;
import com.toysforboys.entities.JobTitel;

public class JobTitelService {
	JobTitelDAO jobTitelDAO = new JobTitelDAO();
	
	public Iterable<JobTitel> findAll() {
		return jobTitelDAO.findall();
	}
	
	public JobTitel read(Long jobTitelNr) {
		return jobTitelDAO.read(jobTitelNr);
	}
}
