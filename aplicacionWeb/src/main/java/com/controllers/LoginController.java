package com.controllers;

import com.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jacobo on 27/11/14.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/Usuarios/login.do",method = RequestMethod.GET)
    public ModelAndView mostrarPagina(){
        return new ModelAndView("login","usuarioLogin",new Usuario());
    }
}
