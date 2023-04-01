package model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {

	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroDiTessera;
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	private Set<Prestito> listaPrestiti;
	
	// COSTRUTTORI
	public Utente() {
		super();
	}
	

	public Utente(String nome, String cognome, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}


	// GETTER E SETTER
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
}
