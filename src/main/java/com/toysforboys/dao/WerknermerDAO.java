package com.toysforboys.dao;

import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import com.toysforboys.entities.Werknemer;

public class WerknermerDAO extends AbstractDAO {
	public Werknemer read(Long werknemersNr) {
		return getEntityManager().find(Werknemer.class, werknemersNr);
	}

	public Werknemer readWithLock(long werknemerNr) {
		return getEntityManager().find(Werknemer.class, werknemerNr,
				LockModeType.PESSIMISTIC_WRITE);
	}
	
	public Werknemer findByJobTitelNr() {
		TypedQuery<Werknemer> query = getEntityManager().createNamedQuery(
				"werknemer.findByJobTitelNr", Werknemer.class);
		return query.getSingleResult();
	}
}
