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

        //aggiungiUtente(utente1);
       // aggiungiElemento(libro1);
      //  aggiungiElemento(rivista1);
        
        List<SupportoCartaceo> catalogo = recuperaCatalogo();
        catalogo.forEach(e -> System.out.println(e));
        
       // rimuoviElemento(1l);
        System.out.println(ricercaPerIsbn(2l));

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
        System.out.println(" è stato aggiunto al catalogo!");
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
    		System.out.println("stefano prende 9.34 nell'esecuzione di un tuffo carpiato");
    		return list;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
    	
    	return null;
    }

}
