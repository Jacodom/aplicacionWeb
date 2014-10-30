package com.services;

import com.dao.DaoUsuario;
import com.model.Usuario;

/**
 * Created by Jacobo on 30/10/14.
 */
public class UsuarioService {

    DaoUsuario daoUsuario = new DaoUsuario();

    public boolean verificarUsername(String username){
        for(Usuario user : daoUsuario.obtener()){
            if(username==user.getNombreUsuario())
                //Falso cuando existe uno que tiene ese nombre
                return false;
        }

        //Verdadero cuando no existe el usuario con ese nombre
        return true;
    }

    public  boolean verificarEmail(String email){
        for(Usuario user : daoUsuario.obtener()){
            if(email==user.getEmailUsuario())
                //Falso cuando existe uno que tiene ese email
                return false;
        }

        //Verdadero cuando no existe un usuario con ese email
        return true;
    }

    public boolean agregarUsuario(Usuario usuario) throws Exception {
        try{
            if(this.verificarUsername(usuario.getNombreUsuario())&&this.verificarEmail(usuario.getEmailUsuario())){
                daoUsuario.agregar(usuario);
                return  true;
            }
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

    public boolean eliminarUsuario(Usuario usuario) throws Exception {
        try{
            daoUsuario.eliminar(usuario);
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

    public boolean modificarUsuario(Usuario usuario) throws Exception {
        try{
            if(this.verificarEmail(usuario.getEmailUsuario())){
                daoUsuario.modificar(usuario);
                return  true;
            }
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

}
