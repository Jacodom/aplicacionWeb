package com.controllers;

import com.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jacobo on 16/02/2015.
 */

@Controller
@SessionAttributes("usuarioSession")
public class ErroresPaginasController {

    String path = "/error";

    @RequestMapping(value = "/404")
    public String error404(){
        return path+"/404";
    }

    @RequestMapping(value = "/500")
    public String error500(){
        return path+"/500";
    }

    @RequestMapping(value = "/Usuarios/accesoDenegado.do")
    public ModelAndView accesoDenegado(@ModelAttribute("usuarioSession")Usuario usuario){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("accesoDenegado");
        mav.addObject("usuarioSession",usuario);

        return mav;
    }
}
