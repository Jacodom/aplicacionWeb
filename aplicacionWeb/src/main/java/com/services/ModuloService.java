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

        public Modulo obtenerModulo(String idModulo){
            daoModulo = new DaoModulo();
            for(Modulo modulo: daoModulo.obtener())
                if (modulo.getIdModulo().equals(idModulo))
                    return modulo;

            return null;
        }

        public List<Modulo> obtenerModulos(){
            daoModulo = new DaoModulo();
            return daoModulo.obtener();
        }

    public boolean agregarModulo(Modulo modulo) throws Exception{
        daoModulo = new DaoModulo();
        try{
            // si el id no es nulo, se modifica
            if(obtenerModulo(modulo.getIdModulo())== null){
                daoModulo.agregar(modulo);
                return true;
                }
            }
        catch (Exception ex){
            throw new Exception("Error",ex);
        }
        return false;
    }

        public boolean modificarModulo(Modulo modulo){
            daoModulo = new DaoModulo();
                if(daoModulo.modificar(modulo))
                    return true;
            else
                    return false;
        }

        public boolean eliminarModulo(Modulo modulo){
            daoModulo = new DaoModulo();
            if(daoModulo.eliminar(modulo))
                return true;
            else
                return false;
        }

        public List<Formulario> obtenerFormulariosModulo(Modulo modulo){
            daoModulo = new DaoModulo();
            return daoModulo.obtenerFormulariosModulo(modulo);
        }
}
