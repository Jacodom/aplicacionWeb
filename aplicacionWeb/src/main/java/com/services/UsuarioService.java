package com.services;

import com.dao.DaoUsuario;
import com.model.Usuario;

import java.util.List;

/**
 * Created by Jacobo on 30/10/14.
 */
public class UsuarioService {

    DaoUsuario daoUsuario;

    public boolean verificarUsername(String username){
        daoUsuario= new DaoUsuario();
        List<Usuario> listaUsuarios = daoUsuario.obtener();
        for(Usuario user : listaUsuarios){
            if(username.equals(user.getIdUsuario()))
                //Falso cuando existe uno que tiene ese nombre
                return false;
        }

        //Verdadero cuando no existe el usuario con ese nombre
        return true;
    }

    public  boolean verificarEmail(String email){
        daoUsuario= new DaoUsuario();
        List<Usuario> listaUsuarios = daoUsuario.obtener();
        for(Usuario user : listaUsuarios){
            if(email.equals(user.getEmailUsuario()))
                //Falso cuando existe uno que tiene ese email
                return false;
        }

        //Verdadero cuando no existe un usuario con ese email
        return true;
    }

    public boolean agregarUsuario(Usuario usuario) throws Exception {
        daoUsuario= new DaoUsuario();
        try{
            if(this.verificarUsername(usuario.getIdUsuario())&&this.verificarEmail(usuario.getEmailUsuario())){
                daoUsuario.agregar(usuario);
                return  true;
            }
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

    public boolean eliminarUsuario(Usuario usuario) throws Exception {
        daoUsuario= new DaoUsuario();
        try{
            daoUsuario.eliminar(usuario);
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }

        return false;
    }

    public boolean modificarUsuario(Usuario usuario) throws Exception {
        daoUsuario= new DaoUsuario();
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
