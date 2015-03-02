package com.controllers;
import com.helpers.ConstructorVistaHelper;
import com.model.Grupo;
import com.model.Usuario;
import com.services.GrupoService;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.SessionAttributesHandler;
import org.springframework.web.servlet.ModelAndView;

import java.security.acl.Group;

/**
 * Created by pablo on 25/02/2015.
 */
@Controller
@SessionAttributes("usuarioSession")

public class GrupoController {
        private GrupoService groupService;
        private UsuarioService userService;

    // GET
    /*@RequestMapping(value = "Grupos/grupo.do", method = RequestMethod.GET)
    public ModelAndView mostrarPagina(@ModelAttribute("usuarioSession") Usuario usuarioSession ,@ModelAttribute ("grupo") Grupo grupo) throws Exception {
        ModelAndView mav = setearVista(new ModelAndView(),"agregarGrupo",usuarioSession);
        return mav;
    }*/
    public ModelAndView setearVista(ModelAndView vista, String nombreVista, Usuario user) throws Exception {
        userService = new UsuarioService();
        vista.setViewName(nombreVista);
        vista.addObject("modulosUsuario", userService.obtenerModulosUsuario(user));
        vista.addObject("perfilesUsuario", userService.obtenerPerfilesUsuario(user));

        return vista;
    }
    @RequestMapping(value = "/Grupos/agregarGrupo.do",method = RequestMethod.GET)
    public ModelAndView agregarGrupoGet(@ModelAttribute ("NuevoGrupo") Grupo grupo) throws Exception {
        ModelAndView mav = setearVista(new ModelAndView(),"agregarGrupo",new Usuario());
        return mav;
    }
    @RequestMapping(value = "/Grupos/addGrupo.do",method = RequestMethod.POST)
    public ModelAndView agregarGrupoPost(@ModelAttribute ("NuevoGrupo") Grupo grupo) throws Exception {
        groupService = new GrupoService();
        ModelAndView mav = new ModelAndView();
            if(groupService.obtenerGrupo(grupo.getIdGrupo())!=null){
                mav.setViewName("agregarGrupo");
                mav.addObject("errorGrupoExist","El grupo ya existe!, pruebe con otro código");
            }else{
                mav.setViewName("agregarGrupo");
                mav.addObject("idGrupo", grupo.getIdGrupo());
                mav.addObject("descripcionGrupo",grupo.getDescripcionGrupo());
                mav.addObject("estadoGrupo",grupo.getEstadoGrupo());
              //  mav.addObject("successGrupo","El grupo se agregó con éxito");
                groupService.agregarGrupo(grupo);
            }

        return mav;
    }



}
