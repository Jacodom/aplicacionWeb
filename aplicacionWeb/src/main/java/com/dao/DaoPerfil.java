package com.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Perfil;

public class DaoPerfil implements DaoBase<Perfil> {
	
	private Session sesion;
	private Transaction transaccion;
		
	
	private void iniciarOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.obtenerInstanciaSesion().openSession();
        transaccion = sesion.beginTransaction(); 
    }  

    private void manejarExcepcion(HibernateException he) throws HibernateException 
    { 
        transaccion.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    }


    @SuppressWarnings("unchecked")
	public List<Perfil> obtener(){
    	try{
    		iniciarOperacion();
    		org.hibernate.Query query = sesion.createQuery("FROM Perfil p"); 
    		List<Perfil> listaPerfiles = query.list();
    		return listaPerfiles;
    	}catch(HibernateException he)
    	{
    		manejarExcepcion(he);
    		throw he;
    	}finally{
    		if(sesion!=null)
    			sesion.close();
    	}
    }
    
	public Boolean agregar(Perfil perfil) {
		 try{ 
		        iniciarOperacion(); 
		        sesion.save(perfil);
		        transaccion.commit(); 
		 }catch(HibernateException he) 
		    { 
		        manejarExcepcion(he);
		        throw he; 
		    }finally 
		    {
		    	if(sesion!=null)
		    		sesion.close(); 
		    }  
		 
		 return true;
	}
	
	public Boolean modificar(Perfil perfil){
		return true;
	}

	public Boolean eliminar(Perfil perfil){
		try{
			iniciarOperacion();
			sesion.delete(perfil);
			transaccion.commit();
		}catch(HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally{
			if(sesion!=null)
				sesion.close();
		}
		
		return true;
		
	}
	
}
