package com.toysforboys.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.toysforboys.valueobjects.EmailAdres;

@Entity
@Table(name = "werknemers")
public class Werknemer {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long werknemersNr;

	private String familienaam;

	private String voornaam;

	@Embedded
	private EmailAdres emailAdres;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefId")
	private Werknemer chef;
	
	
	@OneToMany(mappedBy = "chef")
	private Set<Werknemer> ondergeschikten = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "jobTitelId")
	private JobTitel jobTitel;

	private BigDecimal salaris;

	protected Werknemer() {
	}

	/*public Werknemer(String familienaam, String voornaam, EmailAdres emailAdres,
			JobTitel jobtitel, BigDecimal salaris) {
		setFamilienaam(familienaam);
		setVoornaam(voornaam);
		setEmailAdres(emailAdres);
		setJobTitel(jobtitel);
		setSalaris(salaris);
	}*/

	public Long getWerknemersNr() {
		return werknemersNr;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public EmailAdres getEmailAdres() {
		return emailAdres;
	}

	public Werknemer getChef() {
		return chef;
	}

	public Set<Werknemer> getOndergeschikten() {
		return ondergeschikten;
	}

	public JobTitel getJobTitel() {
		return jobTitel;
	}

	public BigDecimal getSalaris() {
		return salaris;
	}

	/*public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public void setEmailAdres(EmailAdres emailAdres) {
		this.emailAdres = emailAdres;
	}

	public void setChef(Werknemer chef) {
		this.chef = chef;
	}

	public void setOndergeschikten(Set<Werknemer> ondergeschikten) {
		this.ondergeschikten = ondergeschikten;
	}

	public void setJobTitel(JobTitel jobTitel) {
		this.jobTitel = jobTitel;
	}

	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;
	}*/

	public void opslag(BigDecimal opslag) {
		salaris = salaris.add(opslag);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Werknemer)) {
			return false;
		}
		return ((Werknemer) obj).emailAdres.equals(this.emailAdres);
	}

	@Override
	public int hashCode() {
		return emailAdres.hashCode();
	}
	
	public String getVolledigeNaam() {
		return voornaam + " " + familienaam;
	}
}
