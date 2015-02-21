package com.controllers;

import com.model.Modulo;
import com.model.Perfil;
import com.model.Usuario;
import com.services.SeguridadService;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Jacobo on 27/11/14.
 */
@Controller
@SessionAttributes("usuarioSession")

public class LoginController {

    @RequestMapping(value = "/Usuarios/login.do",method = RequestMethod.GET)
    public ModelAndView mostrarPagina(){
        return new ModelAndView("login","usuarioLogin",new Usuario());
    }

    @RequestMapping(value = "/Usuarios/login.do",method = RequestMethod.POST)
    public ModelAndView loginUsuario(@ModelAttribute("usuarioLogin")Usuario usuario)throws Exception{
        UsuarioService userService =  new UsuarioService();
        SeguridadService seguridadService = new SeguridadService();
        ModelAndView mav = new ModelAndView();
        String passIngresada = usuario.getClaveUsuario();

        if(userService.obtenerUsuario(usuario.getIdUsuario())==null) {
            mav.setViewName("login");
            mav.addObject("errorUsername", "El usuario ingresado no existe!");
        }else{
                usuario.setClaveUsuario(seguridadService.encriptarPassword(usuario.getClaveUsuario()));
                if(userService.verificarPassword(usuario)){
                    usuario =userService.obtenerUsuario(usuario.getIdUsuario());
                    if(usuario.getEstadoUsuario()==false){
                        mav.setViewName("login");
                        mav.addObject("errorUsername","El usuario no se encuentra activo!");
                    }else {
                        mav.setViewName("usuario");
                        mav.addObject("usuarioSession", usuario);
                        mav.addObject("modulosUsuario", userService.obtenerModulosUsuario(usuario));
                        mav.addObject("perfilesUsuario", userService.obtenerPerfilesUsuario(usuario));
                    }
                }else{
                    usuario.setClaveUsuario(passIngresada);
                    mav.setViewName("login");
                    mav.addObject("errorPassword","La contraseña es incorrecta!");
                }
            }
        return mav;
    }

    @RequestMapping(value = "/Usuarios/logout.do",method = RequestMethod.GET)
    public ModelAndView logoutUsuario(@ModelAttribute("usuarioLogin")Usuario usuario,SessionStatus status){
        status.setComplete();

        ModelAndView mav= new ModelAndView();

        mav.setViewName("login");

        return mav;
    }

}
