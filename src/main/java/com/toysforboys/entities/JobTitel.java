package com.toysforboys.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobtitels")
public class JobTitel {
	
	@Id
	@GeneratedValue

	private Long Id;

	private String naam;
	
	@OneToMany(mappedBy="jobTitel")
	private Set<Werknemer> werknemers;
	
	protected JobTitel(){
	}
	
	public JobTitel(String naam) {
		setNaam(naam);
	}

	public Long getId() {
		return Id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Set<Werknemer> getWerknemers() {
		return werknemers;
	}

	/*public void setWerknemers(Set<Werknemer> werknemers) {
		this.werknemers = werknemers;
	}*/
	
	
}
