package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceISBN;
	private String titolo;
	private LocalDate annoPubblicazione;
	private Integer numeroPagine;
	private String autore;
	@Enumerated(EnumType.STRING)
    private Genere genere;

//COSTRUTTORI
    public Libro() {

    }

//    public Libro(Long codiceISBN, String titolo,  LocalDate annoPubblicazione, Integer numeroPagine) {
//        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
//    }
//
//
//    public Libro(Long codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, String autore,
//            Genere genere) {
//        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
//        this.autore = autore;
//        this.genere = genere;
//    }


    public String getAutore() {
        return autore;
    }


    public void setAutore(String autore) {
        this.autore = autore;
    }


    public Genere getGenere() {
        return genere;
    }


    public void setGenere(Genere genere) {
        this.genere = genere;
    }

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


    @Override
    public String toString() {
        return "Libro [Autore=" + autore + ", Genere=" + genere + ", Titolo=" + getTitolo()
                + ", Anno di pubblicazione=" + getAnnoPubblicazione() + ", Numero diPagine=" + getNumeroPagine()
                + ", Codice ISBN=" + getCodiceISBN();
    }


}
