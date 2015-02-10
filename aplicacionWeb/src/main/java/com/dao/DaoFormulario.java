package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Formulario;


public class DaoFormulario implements DaoBase<Formulario>{

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
        throw new HibernateException("Ocurrio un error en la capa de acceso a datos", he);
    }

    @SuppressWarnings("unchecked")
	public List<Formulario> obtener(){
    	try{
    		iniciarOperacion();
    		org.hibernate.Query query = sesion.createQuery("FROM Formulario f"); 
    		List<Formulario> listaFormularios = query.list();
    		return listaFormularios;
    	}catch(HibernateException he)
    	{
    		manejarExcepcion(he);
    		throw he;
    	}finally{
    		if(sesion!=null)
    			sesion.close();
    	}
    }

	public Boolean agregar(Formulario formulario) {
		try{ 
	        iniciarOperacion(); 
	        sesion.save(formulario);
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

	public Boolean modificar(Formulario formulario) {
		try
		{
			iniciarOperacion();
			sesion.update(formulario);
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

	public Boolean eliminar(Formulario formulario) {
		try
		{
			iniciarOperacion();
			sesion.delete(formulario);
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
    
}
