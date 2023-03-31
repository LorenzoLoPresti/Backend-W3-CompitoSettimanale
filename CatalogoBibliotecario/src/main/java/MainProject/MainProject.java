package MainProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProject {

	static EntityManagerFactory emf =Persistence.createEntityManagerFactory("CatalogoBibliotecario");

	// l'oggetto che mi servirà per comunicare col db
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
