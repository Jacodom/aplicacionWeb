package dao;

import hibernate.hibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class daoUsuario implements daoBase<Object> {
	
	private Session sesion;
	private Transaction transaccion;
		
	
	private void iniciarOperacion() throws HibernateException 
    { 
        sesion = hibernateUtil.obtenerInstanciaSesion().openSession();
        transaccion = sesion.beginTransaction(); 
    }  

    private void manejarExcepcion(HibernateException he) throws HibernateException 
    { 
        transaccion.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    }


	public Boolean guardarDatos(Object usuario) {


		
		 try{ 
		        iniciarOperacion(); 
		        sesion.save(usuario); 
		        transaccion.commit(); 
		 }catch(HibernateException he) 
		    { 
		        manejarExcepcion(he);
		        throw he; 
		    }finally 
		    { 
		        sesion.close(); 
		    }  
		 
		 return true;
	}
	
	
}
