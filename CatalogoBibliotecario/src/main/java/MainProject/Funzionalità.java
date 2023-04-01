package MainProject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.SupportoCartaceo;
import model.Utente;

public class Funzionalità {
	
		static EntityManagerFactory emf =Persistence.createEntityManagerFactory("CatalogoBibliotecario");

	    static EntityManager em = emf.createEntityManager();

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
