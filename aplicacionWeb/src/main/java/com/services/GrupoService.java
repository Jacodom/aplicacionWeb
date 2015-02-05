package com.services;

import com.dao.DaoGrupo;
import com.model.Grupo;

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


}
