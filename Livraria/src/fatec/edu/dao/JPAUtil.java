package fatec.edu.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private EntityManagerFactory emf;
	private static JPAUtil instancia;
	
	private JPAUtil(){
		emf = Persistence.createEntityManagerFactory("LIVRARIA");
	}
	
	public static JPAUtil getInstance(){
		if(instancia == null){
			instancia = new JPAUtil();
		}
		return instancia;
	}
	
	public EntityManagerFactory getEMF(){
		return emf;
	}
	
}
