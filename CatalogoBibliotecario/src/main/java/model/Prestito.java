package model;

import java.time.LocalDate;

public class Prestito {

	private Utente utente;
	private SupportoCartaceo elementoPrestato;
	private LocalDate inizioPrestito;
	private LocalDate dataRestituzionePrevista; // (calcolata automaticamente a 30 gg dalla data inizio prestito)
	private LocalDate restituzioneEffettiva;
	
	// COSTRUTTORE
	public Prestito() {
		super();
	}

	public Prestito(Utente utente, SupportoCartaceo elementoPrestato, LocalDate inizioPrestito,
			LocalDate dataRestituzionePrevista, LocalDate restituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.inizioPrestito = inizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}
	
	
	// GETTER E SETTER
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public SupportoCartaceo getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(SupportoCartaceo elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
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
