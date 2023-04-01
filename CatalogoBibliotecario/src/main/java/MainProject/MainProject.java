package MainProject;

import java.time.LocalDate;

import model.Genere;
import model.Libro;
import model.Periodicità;
import model.Rivista;
import model.Utente;


public class MainProject {

  

    public static void main(String[] args) {
    	
    	Funzionalità methods = new Funzionalità();

    	// LIBRI, RIVISTE, UTENTI
        Libro libro1 = new Libro();
        libro1.setAnnoPubblicazione(2012);
        libro1.setAutore("Scott");
        libro1.setNumeroPagine(564);
        libro1.setTitolo("Ivanoe");
        libro1.setGenere(Genere.STORICO);
        
        Libro libro2 = new Libro();
        libro2.setAnnoPubblicazione(1949);
        libro2.setAutore("Tolkien");
        libro2.setNumeroPagine(564);
        libro2.setTitolo("Le due torri");
        libro2.setGenere(Genere.FANTASY);
        
        Libro libro3 = new Libro();
        libro3.setAnnoPubblicazione(2022);
        libro3.setAutore("Micano Stefali");
        libro3.setNumeroPagine(669);
        libro3.setTitolo("Il mio dolore si estende");
        libro3.setGenere(Genere.HORROR);
        
        Libro libro4 = new Libro();
        libro4.setAnnoPubblicazione(2023);
        libro4.setAutore("Plaolo Cinna");
        libro4.setNumeroPagine(27);
        libro4.setTitolo("Container: come si usano");
        libro4.setGenere(Genere.SCI_FI);
//
        Rivista rivista1 = new Rivista();
        rivista1.setAnnoPubblicazione(2020);
        rivista1.setNumeroPagine(34);
        rivista1.setTitolo("Tugh life");
        rivista1.setPeriodicità(Periodicità.MENSILE);
        
        Rivista rivista2 = new Rivista();
        rivista2.setAnnoPubblicazione(2014);
        rivista2.setNumeroPagine(36);
        rivista2.setTitolo("Se tu impari Karate vediamo ti schiacciano come uva");
        rivista2.setPeriodicità(Periodicità.SEMESTRALE);


        Utente utente1 = new Utente();
        utente1.setNome("Plaolo");
        utente1.setCognome("Cinna");
        utente1.setDataDiNascita(LocalDate.of(1992, 03, 12));

        // AGGIUNGI ELEMENTO
        
      //  methods.aggiungiUtente(utente1);
      //  aggiungiElemento(rivista2);
      // methods.aggiungiElemento(libro4);
        
        // LISTA DI TUTTI GLI ELEMENTI
        

     //  recuperaCatalogo().forEach(e -> System.out.println(e));
        
        
        // RIMUOVI ELEMENTO
        
     //  methods.rimuoviElemento(11l);
        
        
        // RICERCA PER ISBN
        
       // methods.ricercaPerIsbn(1l);
        
        
        // RICERCA PER ANNO
        
       // methods.ricercaPerAnno(libro1.getAnnoPubblicazione());

        
        //RICERCA PER AUTORE
        
       // methods.ricercaPerAutore("Micano Stefali");
        
        
        // RICERCA PER TITOLO O PARTE DI ESSO
       
        // methods.ricercaPerTitolo("no");
    }

  


}
