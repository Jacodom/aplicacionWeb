package com.controllers;

import com.model.Usuario;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jacobo on 25/10/14.
 */


@Controller
@RequestMapping(value = "/Usuarios")
public class UsuarioController {

    @RequestMapping(value = "/verifyUsuario",method = RequestMethod.POST)
    @ResponseBody public boolean verificarUsername(@RequestBody String username){
        UsuarioService userService = new UsuarioService();

        if(userService.verificarUsername(username)){
           return true;
        }
        else{
            return false;
        }
    }

    @RequestMapping(value = "/verifyEmail",method = RequestMethod.POST)
    @ResponseBody public boolean verificarEmail(@RequestBody String email){
        UsuarioService userService = new UsuarioService();

        if (userService.verificarEmail(email)) {
            return true;
        } else {
            return false;
        }
    }


    //terminar
    @RequestMapping(value = "/addUsuario",method = RequestMethod.POST)
    @ResponseBody public Usuario agregarUsuario(@RequestBody Usuario usuario){
        return usuario;
    }

}
