package com.dao;

import java.util.List;


import com.model.Grupo;
import com.model.Perfil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Usuario;

public class DaoUsuario implements DaoBase<Usuario> {
	
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
	public List<Usuario> obtener(){
    	try{
    		iniciarOperacion();
    		org.hibernate.Query query = sesion.createQuery("FROM Usuario u"); 
    		List<Usuario> listaUsuarios = query.list();
    		return listaUsuarios;
    	}catch(HibernateException he)
    	{
    		manejarExcepcion(he);
    		throw he;
    	}finally{
    		if(sesion!=null)
    			sesion.close();
    	}
    }


    
	public Boolean agregar(Usuario usuario) {
		 try{ 
		        iniciarOperacion(); 
		        sesion.merge(usuario);
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
	
	public Boolean modificar(Usuario usuario){
		try{
			iniciarOperacion();
			sesion.merge(usuario);
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

	public Boolean eliminar(Usuario usuario){
		try{
			iniciarOperacion();
			sesion.delete(usuario);

			//Query q = sesion.createQuery("DELETE from Usuario where idUsuario = :idUsuario")
			//		.setParameter("idUsuario",usuario.getIdUsuario());
			//q.executeUpdate();
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

	public List<Grupo> obtenerGruposUsuario(Usuario usuario){
		try {
			iniciarOperacion();
			List<Grupo> listaGrupos = sesion.createQuery("SELECT grupos FROM Usuario u " +
					"where u.idUsuario= :idUsuario").setParameter("idUsuario", usuario.getIdUsuario()).list();
			return listaGrupos;
		}catch(HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally {
			if(sesion!=null)
				sesion.close();
		}
	}

	public List<Usuario>obtenerPorPagina(int primerResultado, int maximosResultados){
		try{
			iniciarOperacion();
			List<Usuario>listaUsuarios = sesion.createQuery("FROM Usuario u order by u.nombreUsuario asc ")
					.setFirstResult(primerResultado)
					.setMaxResults(maximosResultados).list();
			return listaUsuarios;
		}catch (HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally {
			if(sesion!=null)
				sesion.close();
		}
	}

}
