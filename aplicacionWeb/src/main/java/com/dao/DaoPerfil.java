package com.dao;

import java.util.List;

import com.model.Formulario;
import com.model.Grupo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtil;
import com.model.Perfil;
import org.springframework.orm.hibernate3.HibernateTemplate;
import sun.misc.Perf;

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
        throw new HibernateException("Ocurri� un error en la capa de acceso a datos", he); 
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
			Query q = sesion.createQuery("DELETE from Perfil where idPerfil = :idPerfil")
					.setParameter("idPerfil",perfil.getIdPerfil());
			q.executeUpdate();
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

	public List<Perfil>obtenerPorPagina(int primerResultado, int maximosResultados){
		try{
			iniciarOperacion();
			List<Perfil>listaPerfiles = sesion.createQuery("FROM Perfil p order by p.idPerfil asc ")
					.setFirstResult(primerResultado)
					.setMaxResults(maximosResultados).list();
			return listaPerfiles;
		}catch (HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally {
			if(sesion!=null)
				sesion.close();
		}
	}

	public List<Perfil> filtrarPerfiles(Grupo grupo,Formulario formulario){
		try {
			iniciarOperacion();
			List<Perfil> listaPerfiles = sesion.createQuery("SELECT Perfil FROM Perfil p " +
					"where p.grupo.idGrupo = :idGrupo " +
					"and p.formulario.idFormulario= :idFormulario")
					.setParameter("idGrupo",grupo.getIdGrupo())
					.setParameter("idFormulario",formulario.getIdFormulario()).list();
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
