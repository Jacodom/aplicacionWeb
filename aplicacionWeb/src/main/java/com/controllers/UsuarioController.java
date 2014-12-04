package com.controllers;

import com.model.Usuario;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jacobo on 25/10/14.
 */


@Controller
public class UsuarioController {

    private UsuarioService userService;

    @RequestMapping(value = "/Usuarios/agregarUsuario",method = RequestMethod.GET)
    public ModelAndView mostrarPagina(){
        return new ModelAndView("agregarUsuario","usuario",new Usuario());
    }


    @RequestMapping(value = "/Usuarios/verifyUsuario.do",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody public boolean verificarUsername(@RequestBody String username){
        userService=new UsuarioService();
        if(userService.verificarUsername(username)){
           return true;
        }
        else{
            return false;
        }
    }

    @RequestMapping(value = "/Usuarios/verifyEmail.do",method = RequestMethod.POST)
    @ResponseBody public boolean verificarEmail(@RequestBody String email){
        userService=new UsuarioService();
        if (userService.verificarEmail(email)) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/Usuarios/addUsuario.do",method = RequestMethod.POST)
    public ModelAndView agregarUsuario(@ModelAttribute("usuario") Usuario usuario) throws Exception {
        userService=new UsuarioService();

        ModelAndView mav = new ModelAndView();


        if (userService.agregarUsuario(usuario)){
            System.out.println("llegue 1");
            mav.setViewName("usuarioAgregado");
            return mav;
        }else{
            System.out.println("llegue 2");
            mav.setViewName("errorAgregarUsuario");
            return mav;
        }
    }


}
