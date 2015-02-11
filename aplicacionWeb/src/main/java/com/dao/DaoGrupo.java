package com.dao;

import java.util.List;

import com.model.Perfil;
import com.model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Grupo;


public class DaoGrupo implements DaoBase<Grupo>{

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
	public List<Grupo> obtener(){
    	try{
    		iniciarOperacion();
    		org.hibernate.Query query = sesion.createQuery("FROM Grupo g"); 
    		List<Grupo> listaGrupos = query.list();
    		return listaGrupos;
    	}catch(HibernateException he)
    	{
    		manejarExcepcion(he);
    		throw he;
    	}finally{
    		if(sesion!=null)
    			sesion.close();
    	}
    }

	public Boolean agregar(Grupo grupo) {
		try{ 
	        iniciarOperacion(); 
	        sesion.save(grupo);
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

	public Boolean modificar(Grupo grupo) {
		try
		{
			iniciarOperacion();
			sesion.update(grupo);
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

	public Boolean eliminar(Grupo grupo) {
		try
		{
			iniciarOperacion();
			sesion.delete(grupo);
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

	public List<Usuario>obtenerUsuariosGrupo(Grupo grupo){
		try{
			iniciarOperacion();
			List<Usuario> listaUsuarios = sesion.createQuery("SELECT usuarios FROM Grupo g where g.idGrupo= :idGrupo")
					.setParameter("idGrupo",grupo.getIdGrupo()).list();
			return listaUsuarios;
		}catch (HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally {
			if(sesion!=null)
				sesion.close();
		}
	}

	public List<Perfil> obtenerPerfilesGrupo(Grupo grupo){
		try{
			iniciarOperacion();
			List<Perfil> listaPerfiles = sesion.createQuery("SELECT perfiles from Grupo g where g.idGrupo = :idGrupo")
					.setParameter("idGrupo",grupo.getIdGrupo()).list();
			return listaPerfiles;
		}catch (HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally {
			if(sesion!=null)
				sesion.close();
		}
	}
    
}
