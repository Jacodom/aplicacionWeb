package com.services;

import com.dao.DaoGrupo;
import com.model.Grupo;
import com.model.Usuario;

import java.util.List;

/**
 * Created by Jacobo on 05/02/2015.
 */
public class GrupoService {

    DaoGrupo daoGrupo;

    public Grupo obtenerGrupo(String idGrupo){
        daoGrupo = new DaoGrupo();
        for(Grupo group : daoGrupo.obtener())
            if(group.getIdGrupo().equals(idGrupo))
                return group;

        return null;
    }

    public List<Grupo> obtenerGrupos(){
        daoGrupo = new DaoGrupo();
        return daoGrupo.obtener();
    }

    public boolean agregarGrupo(Grupo grupo)throws Exception{
        daoGrupo = new DaoGrupo();
        try{
            if(obtenerGrupo(grupo.getIdGrupo())==null) {
                daoGrupo.agregar(grupo);
                return true;
            }
        }catch (Exception ex){
            throw new Exception("Error!",ex);
        }
        return false;
    }

    public boolean modificarGrupo(Grupo grupo)throws Exception{
        daoGrupo = new DaoGrupo();
        if(daoGrupo.modificar(grupo))
            return  true;
        else
            return false;
    }

    public boolean eliminarGrupo(Grupo grupo)throws Exception{
        daoGrupo = new DaoGrupo();
        if(daoGrupo.eliminar(grupo))
            return true;
        else
            return false;
    }

    public List<Usuario> obtenerUsuariosGrupo(Grupo grupo)throws Exception{
        daoGrupo = new DaoGrupo();
        return daoGrupo.obtenerUsuariosGrupo(grupo);
    }
}
