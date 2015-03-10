package com.services;

import com.dao.DaoPerfil;
import com.model.Formulario;
import com.model.Grupo;
import com.model.Perfil;

import java.util.List;

/**
 * Created by Jacobo on 03/03/2015.
 */
public class PerfilService {

    public Perfil obtenerPerfil(int idPerfil){
        DaoPerfil daoPerfil = new DaoPerfil();

        for(Perfil perfil : daoPerfil.obtener()){
            if(perfil.getIdPerfil()==idPerfil){
                return perfil;
            }
        }

        return null;
    }

    public List<Perfil> obtenerPerfiles(){
        DaoPerfil daoPerfil = new DaoPerfil();
        return daoPerfil.obtener();
    }

    public boolean verificarPerfil(Perfil perfil){
        DaoPerfil daoPerfil = new DaoPerfil();
        for(Perfil perfilBD : daoPerfil.obtener()) {
            if (perfilBD.getGrupo().getIdGrupo().equals(perfil.getGrupo().getIdGrupo())) {
                if (perfilBD.getFormulario().getIdFormulario().equals(perfil.getFormulario().getIdFormulario())) {
                    //true cuando existe uno
                    return true;
                }
            }
        }
        return false;
    }


    public List<Perfil> obtenerPerfilesPorPagina(int pagina, int maximosResultados){
        DaoPerfil daoPerfil = new DaoPerfil();
        int primerResultado = pagina * maximosResultados - maximosResultados;
        return daoPerfil.obtenerPorPagina(primerResultado,maximosResultados);
    }

    public boolean agregarPerfil(Perfil perfil){
        DaoPerfil daoPerfil = new DaoPerfil();

        if(daoPerfil.agregar(perfil)){
            return true;
        }else {
            return false;
        }
    }

    public boolean modificarPerfil(Perfil perfil){
        DaoPerfil daoPerfil = new DaoPerfil();

        if(daoPerfil.modificar(perfil)){
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarPerfil(Perfil perfil){
        DaoPerfil daoPerfil = new DaoPerfil();

        if(daoPerfil.eliminar(perfil)){
            return true;
        }else{
            return false;
        }
    }

    public List<Perfil>filtrarPerfiles(Grupo grupo,Formulario formulario){
        DaoPerfil daoPerfil = new DaoPerfil();

        return daoPerfil.filtrarPerfiles(grupo,formulario);
    }
}
