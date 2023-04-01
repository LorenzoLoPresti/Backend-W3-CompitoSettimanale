package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rivista")
public class Rivista{

	@Id
	private Long codiceISBN;
	private String titolo;
	private LocalDate annoPubblicazione;
	private Integer numeroPagine;
    private Periodicità periodicità;


//COSTRUTTORI
    public Rivista() {

    }



//GETTERS & SETTERS

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



	public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }



    @Override
    public String toString() {
        return "Rivista [Titolo=" + getTitolo()
                + ", Anno di pubblicazione=" + getAnnoPubblicazione() + ", Numero di Pagine=" + getNumeroPagine()
                + ", Codice ISBN=" + getCodiceISBN() + ", Periodicità=" + getPeriodicità();
    }

}