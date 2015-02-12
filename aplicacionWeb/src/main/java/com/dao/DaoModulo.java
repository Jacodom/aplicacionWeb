package com.dao;

import java.util.List;

	import com.model.Formulario;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;


import com.hibernate.HibernateUtil;
import com.model.Modulo;

public class DaoModulo implements DaoBase<Modulo> {
	
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
        throw new HibernateException("Ocurri� un error en la capa de acceso a datos", he); 
    }


    @SuppressWarnings("unchecked")
	public List<Modulo> obtener(){
    	try{
    		iniciarOperacion();
    		org.hibernate.Query query = sesion.createQuery("FROM Modulo m"); 
    		List<Modulo> listaModulos = query.list();
    		return listaModulos;
    	}catch(HibernateException he)
    	{
    		manejarExcepcion(he);
    		throw he;
    	}finally{
    		if(sesion!=null)
    			sesion.close();
    	}
    }
    
	public Boolean agregar(Modulo modulo) {
		 try{ 
		        iniciarOperacion(); 
		        sesion.save(modulo);
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
	
	public Boolean modificar(Modulo modulo){
		try{
			iniciarOperacion();
			sesion.update(modulo);
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

	public Boolean eliminar(Modulo modulo){
		try{
			iniciarOperacion();
			sesion.delete(modulo);
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
	public List<Formulario> obtenerFormulariosModulo(Modulo modulo){
		try{
			iniciarOperacion();
			List<Formulario> listaFormularios = sesion.createQuery("SELECT formularios FROM Modulo m where m.idModulo= :idModulo").setParameter("idModulo",modulo.getIdModulo()).list();
			return listaFormularios;
		}catch (HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally {
			if(sesion!=null)
				sesion.close();
		}
	}
	
}
