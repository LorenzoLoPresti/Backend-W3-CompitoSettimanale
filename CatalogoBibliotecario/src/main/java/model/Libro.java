package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name = "libri")
public class Libro extends SupportoCartaceo{

	
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

//COSTRUTTORI
    public Libro() {

    }

    public Libro(Long codiceISBN, String titolo,  int annoPubblicazione, Integer numeroPagine) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
    }


    public Libro(Long codiceISBN, String titolo, int annoPubblicazione, Integer numeroPagine, String autore,
            Genere genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }


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


    @Override
    public String toString() {
        return "Libro [Autore=" + autore + ", Genere=" + genere + ", Titolo=" + getTitolo()
                + ", Anno di pubblicazione=" + getAnnoPubblicazione() + ", Numero diPagine=" + getNumeroPagine()
                + ", Codice ISBN=" + getCodiceISBN();
    }


}
