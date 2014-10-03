package dao;

import java.util.List;



import hibernate.hibernateUtil;
import model.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class daoUsuario implements daoBase<Usuario> {
	
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
    		sesion.close();
    	}
    }
    
	public Boolean agregar(Usuario usuario) {
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
	
	public Boolean modificar(Usuario usuario){
		try{
			iniciarOperacion();
			sesion.update(usuario);
			transaccion.commit();
		}catch(HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally{
			sesion.close();
		}
		
		return true;
	}

	public Boolean eliminar(Usuario usuario){
		try{
			iniciarOperacion();
			sesion.delete(usuario);
			transaccion.commit();
		}catch(HibernateException he){
			manejarExcepcion(he);
			throw he;
		}finally{
			sesion.close();
		}
		
		return true;
		
	}
	
}
