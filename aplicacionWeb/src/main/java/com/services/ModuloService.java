package com.services;
import com.dao.DaoModulo;
import com.model.Modulo;
import com.model.Formulario;

import java.util.List;

/**
 * Created by pablo on 10/02/2015.
 */
public class ModuloService {
    DaoModulo daoModulo;

        public Modulo ObtenerModulo(String idModulo){
            daoModulo = new DaoModulo();
            for(Modulo modulo: daoModulo.obtener())
                if (modulo.getIdModulo().equals(idModulo))
                    return modulo;

            return null;
        }
    public List<Modulo> ObtenerModulos(){
        daoModulo = new DaoModulo();
        return daoModulo.obtener();
    }
    public boolean AgregarModulo(Modulo modulo) throws Exception{
        daoModulo = new DaoModulo();
        try{
            // si el id no es nulo, se modifica
            if(ObtenerModulo(modulo.getIdModulo())== null){
                daoModulo.agregar(modulo);
                return true;
                }
            }
        catch (Exception ex){
            throw new Exception("Error",ex);
        }
        return false;
    }
    public boolean ModificarModulo(Modulo modulo){
        daoModulo = new DaoModulo();
            if(daoModulo.modificar(modulo))
                return true;
        else
                return false;
    }
    public boolean EliminarModulo(Modulo modulo){
        daoModulo = new DaoModulo();
        if(daoModulo.eliminar(modulo))
            return true;
        else
            return false;
    }
    public List<Formulario> obtenerFormulariosModulos(Modulo modulo) throws Exception{
        daoModulo = new DaoModulo();
        return daoModulo.ObtenerFormulariosModulos(modulo);
    }
}
