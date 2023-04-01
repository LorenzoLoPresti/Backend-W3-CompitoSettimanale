package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
public class Prestito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Libro libroPrestato;
	@ManyToOne
	private Rivista rivistaPrestata;
	@Column
	private LocalDate inizioPrestito;
	@Column
	private LocalDate dataRestituzionePrevista; // (calcolata automaticamente a 30 gg dalla data inizio prestito)
	@Column
	private LocalDate restituzioneEffettiva;
	
	// COSTRUTTORE
	public Prestito() {
		super();
	}


	
	// GETTER E SETTER
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Libro getLibroPrestato() {
		return libroPrestato;
	}



	public void setLibroPrestato(Libro libroPrestato) {
		this.libroPrestato = libroPrestato;
	}



	public Rivista getRivistaPrestata() {
		return rivistaPrestata;
	}



	public void setRivistaPrestata(Rivista rivistaPrestata) {
		this.rivistaPrestata = rivistaPrestata;
	}



	public LocalDate getInizioPrestito() {
		return inizioPrestito;
	}

	public void setInizioPrestito(LocalDate inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}
	
}
