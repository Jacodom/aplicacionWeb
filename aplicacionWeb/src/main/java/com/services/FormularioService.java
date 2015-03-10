package com.services;

/**
 * Created by pablo on 10/02/2015.
 */
import javassist.bytecode.stackmap.BasicBlock;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Formulario;
import com.model.Perfil;
import com.model.Permiso;
import com.dao.DaoFormulario;

import java.util.List;

public class FormularioService {
    DaoFormulario  daoFormulario;

    public Formulario obtenerFormulario(String idFormulario){
        daoFormulario = new DaoFormulario();
        for (Formulario formulario: daoFormulario.obtener())
            if(formulario.getIdFormulario().equals(idFormulario))
                return formulario;

        return null;
    }
    public List<Formulario> obtenerFormularios(){
        daoFormulario = new DaoFormulario();
        return daoFormulario.obtener();
    }
    public boolean agregarFormulario(Formulario formulario) throws Exception{
        daoFormulario = new DaoFormulario();
        try{
            if(obtenerFormulario(formulario.getIdFormulario())== null) {
                daoFormulario.agregar(formulario);
                return true;
            }
        }catch (Exception ex){
            throw new Exception("Error",ex);
        }

        return false;
    }
    public boolean modificarFormulario(Formulario formulario) throws Exception{
        daoFormulario = new DaoFormulario();
        if(daoFormulario.modificar(formulario))
            return true;
        else
            return false;
    }
    public boolean eliminarFormulario(Formulario formulario) throws Exception{
        daoFormulario = new DaoFormulario();
        if(daoFormulario.eliminar(formulario))
            return true;
        else
            return false;
    }
    public List<Perfil> obtenerPerfilesFormulario(Formulario formulario) throws Exception{
        daoFormulario = new DaoFormulario();
        return daoFormulario.ObtenerPerfilesFormulario(formulario);
    }
    public List<Permiso> obtenerPermisosFormularios(Formulario formulario) throws  Exception{
        daoFormulario= new DaoFormulario();
        return daoFormulario.ObtenerPermisosFormulario(formulario);
    }
}
