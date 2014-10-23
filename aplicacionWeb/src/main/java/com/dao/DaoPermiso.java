package com.dao;

import java.util.List;







import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Permiso;

public class DaoPermiso implements DaoBase<Permiso> {
	
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
	public List<Permiso> obtener(){
    	try{
    		iniciarOperacion();
    		org.hibernate.Query query = sesion.createQuery("FROM Permiso u"); 
    		List<Permiso> listaPermisos = query.list();
    		return listaPermisos;
    	}catch(HibernateException he)
    	{
    		manejarExcepcion(he);
    		throw he;
    	}finally{
    		if(sesion!=null)
    			sesion.close();
    	}
    }
    
	public Boolean agregar(Permiso permiso) {
		 try{ 
		        iniciarOperacion(); 
		        sesion.save(permiso);
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
	
	public Boolean modificar(Permiso permiso){
		try{
			iniciarOperacion();
			sesion.update(permiso);
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

	public Boolean eliminar(Permiso permiso){
		try{
			iniciarOperacion();
			sesion.delete(permiso);
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
