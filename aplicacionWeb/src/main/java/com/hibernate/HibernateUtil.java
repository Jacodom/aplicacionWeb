package com.hibernate;

import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Configuration cfg;
	
	public static SessionFactory obtenerInstanciaSesion(){
		try{
			if(sessionFactory==null)
			{
				cfg = new Configuration();
				cfg.configure();
				serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
				
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			}
		}catch(Throwable ex){
			ex.printStackTrace();
		}
		
		
		return sessionFactory;
	}
	
	
}
