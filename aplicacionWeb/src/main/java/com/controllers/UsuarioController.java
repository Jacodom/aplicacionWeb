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

    private UsuarioService userService;

    @RequestMapping(value = "/verifyUsuario.do",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody public boolean verificarUsername(@RequestBody String username){
        userService=new UsuarioService();
        if(userService.verificarUsername(username)){
           return true;
        }
        else{
            return false;
        }
    }

    @RequestMapping(value = "/verifyEmail.do",method = RequestMethod.POST)
    @ResponseBody public boolean verificarEmail(@RequestBody String email){
        userService=new UsuarioService();
        if (userService.verificarEmail(email)) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/addUsuario.do",method = RequestMethod.POST)
    @ResponseBody public boolean agregarUsuario(@RequestBody Usuario usuario) throws Exception {
        userService=new UsuarioService();
        if (userService.agregarUsuario(usuario)){
            return true;
        }else{
            return false;
        }
    }

}
