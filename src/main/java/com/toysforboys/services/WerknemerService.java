package com.toysforboys.services;

import java.math.BigDecimal;

import com.toysforboys.dao.WerknermerDAO;
import com.toysforboys.entities.Werknemer;
import com.toysforboys.exeptions.WerknemerNietGevondenException;

public class WerknemerService {
	WerknermerDAO werknermerDAO = new WerknermerDAO();
	
	public Werknemer read(Long werknemersNr) {
		return werknermerDAO.read(werknemersNr);
	}
	
	public void opslag(long werknemerNr, BigDecimal opslagBedrag) {
		werknermerDAO.beginTransaction();
		Werknemer werknemer = werknermerDAO.readWithLock(werknemerNr);
		if (werknemer == null) {
			throw new WerknemerNietGevondenException();
		}
		werknemer.opslag(opslagBedrag);
		werknermerDAO.commit();
	}
	
	public Werknemer findByJobTitelNr() {
		return werknermerDAO.findByJobTitelNr();
	}
}
