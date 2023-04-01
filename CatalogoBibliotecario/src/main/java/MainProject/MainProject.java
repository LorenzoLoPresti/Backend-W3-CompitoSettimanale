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
import model.SupportoCartaceo;
import model.Utente;


public class MainProject {

    static EntityManagerFactory emf =Persistence.createEntityManagerFactory("CatalogoBibliotecario");

    // l'oggetto che mi servirà per comunicare col db
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

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
        
      // aggiungiUtente(utente1);
      //  aggiungiElemento(rivista2);
       // aggiungiElemento(libro4);
        
        // LISTA DI TUTTI GLI ELEMENTI
        

     //  recuperaCatalogo().forEach(e -> System.out.println(e));
        
        
        // RIMUOVI ELEMENTO
        
     //   rimuoviElemento(9l);
        
        
        // RICERCA PER ISBN
        
     //   ricercaPerIsbn(1l);
        
        
        // RICERCA PER ANNO
        
       // ricercaPerAnno(libro1.getAnnoPubblicazione());

        
        //RICERCA PER AUTORE
        
       // ricercaPerAutore("Micano Stefali");
        
        
        // RICERCA PER TITOLO O PARTE DI ESSO
       
     //  ricercaPerTitolo("no");
    }

    public static void aggiungiElemento(SupportoCartaceo elem) {
        try {
        em.getTransaction().begin();
        em.persist(elem);
        em.getTransaction().commit();
        System.out.println(elem.getTitolo() + " è stato aggiunto al catalogo!");
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
        System.out.println(" Utente aggiunto!");
        }
        catch (Exception e) {
            e.getMessage();
        } finally {
            em.close();
        }
    }

    public static List<SupportoCartaceo> recuperaCatalogo(){
        em.getTransaction().begin();
        Query q = em.createNamedQuery("SupportoCartaceo.findAll");
        em.getTransaction().commit();
        return q.getResultList();
    }
    
    public static void rimuoviElemento(Long isbn) {
    	try {
    		em.getTransaction().begin();
    		Query querySelect = em.createQuery("DELETE SupportoCartaceo s WHERE s.codiceISBN = :id");
    		querySelect.setParameter("id", isbn);
    		querySelect.executeUpdate();
    		em.getTransaction().commit();
    		System.out.println("elemento rimosso per codice: " + isbn);
    	} catch (Exception e) {
			e.getMessage();
		} finally {
			em.close();
		}
    }
    
    public static SupportoCartaceo ricercaPerIsbn(Long isbn){
    	
    	try {
    		em.getTransaction().begin();
    		Query querySelect = em.createQuery("SELECT s FROM SupportoCartaceo s WHERE s.codiceISBN = :id");
    		querySelect.setParameter("id", isbn);
    		SupportoCartaceo list = (SupportoCartaceo) querySelect.getSingleResult();
    		em.getTransaction().commit();
    		System.out.println("La tua ricerca ha dato i seguenti risultati:");
    		System.out.println(list.toString());
    		return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
    	
    	return null;
    }
    
    public static List<SupportoCartaceo> ricercaPerAnno(int date){
    	
    	try {
    		em.getTransaction().begin();
    	     Query querySelect = em.createQuery("SELECT s FROM SupportoCartaceo s WHERE s.annoPubblicazione = :date");
    	     querySelect.setParameter("date", date);
    		List<SupportoCartaceo> list = querySelect.getResultList();
    		em.getTransaction().commit();
    		System.out.println("La tua ricerca ha dato i seguenti risultati:");
    		list.forEach(e -> System.out.println(e));
    		return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
    	
    	return null;
    }
    
  public static List<SupportoCartaceo> ricercaPerAutore(String author){
    	
    	try {
    		em.getTransaction().begin();
    		Query querySelect = em.createQuery("SELECT s FROM SupportoCartaceo s WHERE s.autore = :author");
    		querySelect.setParameter("author", author);
    		List<SupportoCartaceo> list = querySelect.getResultList();
    		em.getTransaction().commit();
    		System.out.println("La tua ricerca ha dato i seguenti risultati:");
    		list.forEach(e -> System.out.println(e));
    		return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
    	
    	return null;
    }
  
  public static List<SupportoCartaceo> ricercaPerTitolo(String title){
  	
  	try {
  		em.getTransaction().begin();
  		Query querySelect = em.createQuery("SELECT s FROM SupportoCartaceo s WHERE s.titolo LIKE :titolo");
  		querySelect.setParameter("titolo", "%" + title + "%" );
  		List<SupportoCartaceo> list = querySelect.getResultList();
  		em.getTransaction().commit();
  		System.out.println("La tua ricerca ha dato i seguenti risultati:");
		list.forEach(e -> System.out.println(e));
  		return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
  	
  	return null;
  }


}
