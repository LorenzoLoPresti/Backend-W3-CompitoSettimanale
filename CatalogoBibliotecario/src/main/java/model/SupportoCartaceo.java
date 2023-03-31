package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SupportoCartaceo {
	
	@Id
	private Long codiceISBN;
	private String titolo;
	private LocalDate annoPubblicazione;
	private Integer numeroPagine;
	
	
	// COSTRUTTORE
	public SupportoCartaceo() {
		super();
	}
	
	
	public SupportoCartaceo(Long codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine) {
		super();
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}


	// GETTER E SETTER
	public Long getCodiceISBN() {
		return codiceISBN;
	}
	
	public void setCodiceISBN(Long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public LocalDate getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	
	public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	
	public Integer getNumeroPagine() {
		return numeroPagine;
	}
	
	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	
	
}
