package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class prueba {

public void asd(){
		
		Usuario user = new Usuario();
		user.setIdUsuario("jacodom");
		user.setNombreUsuario("jacobo");
		user.setClaveUsuario("asdasd");
		user.setEmailUsuario("asd@asd.com");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("aplicacionWeb");
		EntityManager em = emf.createEntityManager();
		
		System.out.println(user.getIdUsuario());
		
		try{
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
	}
}
