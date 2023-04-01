package MainProject;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Genere;
import model.Libro;
import model.Periodicità;
import model.Rivista;
import model.Utente;

public class MainProject {

    static EntityManagerFactory emf =Persistence.createEntityManagerFactory("CatalogoBibliotecario");

    // l'oggetto che mi servirà per comunicare col db
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Libro libro1 = new Libro();
        libro1.setAnnoPubblicazione(LocalDate.of(2012, 11, 11));
        libro1.setAutore("B. Cornwell");
        libro1.setNumeroPagine(564);
        libro1.setTitolo("I re sassoni");
        libro1.setGenere(Genere.STORICO);
//
        Rivista rivista1 = new Rivista();
        rivista1.setAnnoPubblicazione(LocalDate.of(2012, 11, 11));
        rivista1.setNumeroPagine(34);
        rivista1.setTitolo("Kung fu magazine");
        rivista1.setPeriodicità(Periodicità.MENSILE);


        Utente utente1 = new Utente();
        utente1.setNome("Antonio");
        utente1.setCognome("D'Amico");
        utente1.setDataDiNascita(LocalDate.of(1992, 03, 12));

       // aggiungiUtente(utente1);
       // aggiungiLibro(libro1);
       // aggiungiRivista(rivista1);

    }

    public static void aggiungiLibro(Libro libro) {
        try {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        System.out.println(libro.getTitolo() + " è stato aggiunto al catalogo!");
        }
        catch (Exception e) {
            e.getMessage();
        } finally {
            em.close();
        }
    }
    
    public static void aggiungiRivista(Rivista rivista) {
        try {
        em.getTransaction().begin();
        em.persist(rivista);
        em.getTransaction().commit();
        System.out.println(rivista.getTitolo() + " è stato aggiunto al catalogo!");
        }
        catch (Exception e) {
            e.getMessage();
        } finally {
            em.close();
        }
    }
    

    public static void aggiungiUtente(Utente utente) {
        try {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        System.out.println(" è stato aggiunto al catalogo!");
        }
        catch (Exception e) {
            e.getMessage();
        } finally {
            em.close();
        }
    }

//    public static List<Elemento> recuperaCatalogo(){
//        em.getTransaction().begin();
//        Query q = em.createNamedQuery("Elementi.FindAll");
//        em.getTransaction().commit();
//        return (List<Elemento>) q;
//    }

}
