package com.dao;

import java.util.List;




public interface DaoBase<T> {
	
	public List<T> obtener();
	public Boolean agregar(T objeto);
	public Boolean modificar(T objeto);
	public Boolean eliminar(T objeto);
}
