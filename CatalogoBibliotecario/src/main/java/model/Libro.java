package model;

import java.time.LocalDate;

public class Libro extends SupportoCartaceo{

	private String autore;
	private Genere genere;
	
	// COSTRUTTORE
	public Libro(Long codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
	}


	public Libro(Long codiceISBN, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, String autore, Genere genere) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	// GETTER E SETTER
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
		return "Libro [autore=" + autore + ", genere=" + genere + ", CodiceISBN =" + getCodiceISBN()
				+ ", Titolo=" + getTitolo() + ", AnnoPubblicazione =" + getAnnoPubblicazione()
				+ ", NumeroPagine =" + getNumeroPagine() + "]";
	}
	
	
}
