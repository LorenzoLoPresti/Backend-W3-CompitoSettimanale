package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends SupportoCartaceo{
	
	@Column
	private Periodicità periodicità;
	
	// COSTRUTTORE
	public Rivista() {};
	
	public Rivista(Long codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		
	}
	
	public Rivista(Long codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, Periodicità periodicità) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicità = periodicità;
	}

	
	// GETTERE E SETTER
	public Periodicità getPeriodicità() {
		return periodicità;
	}
	
	public void setPeriodicità(Periodicità periodicità) {
		this.periodicità = periodicità;
	}
	
	public String toString() {
		return "Rivista [ CodiceISBN =" + getCodiceISBN()
				+ ", Titolo=" + getTitolo() + ", AnnoPubblicazione =" + getAnnoPubblicazione()
				+ ", NumeroPagine =" + getNumeroPagine() + ", Periodicità =" + getPeriodicità() + "]";
	}
	
}
