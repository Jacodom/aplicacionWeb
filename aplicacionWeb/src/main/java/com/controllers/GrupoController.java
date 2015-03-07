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
    @RequestMapping(value = "/Grupos/agregarGrupo.do",method = RequestMethod.GET)
    public ModelAndView agregarGrupoGet(@ModelAttribute ("NuevoGrupo") Grupo grupo,@ModelAttribute("usuarioSession")Usuario usuarioSession) throws Exception {
        ModelAndView mav = setearVista(new ModelAndView(),"agregarGrupo", usuarioSession);
        return mav;
    }
    public ModelAndView setearVista(ModelAndView vista, String nombreVista, Usuario user) throws Exception {
        userService = new UsuarioService();
        vista.setViewName(nombreVista);
        vista.addObject("modulosUsuario", userService.obtenerModulosUsuario(user));
        vista.addObject("perfilesUsuario", userService.obtenerPerfilesUsuario(user));

        return vista;
    }
    @RequestMapping(value = "/Grupos/addGrupo.do",method = RequestMethod.POST) // agregar usuario session al post
    public ModelAndView agregarGrupoPost(@ModelAttribute ("NuevoGrupo") Grupo grupo,@ModelAttribute("usuarioSession")Usuario usuarioSession) throws Exception {
        groupService = new GrupoService();
        ModelAndView mav = setearVista(new ModelAndView(),"agregarGrupo", usuarioSession);
            /*if(groupService.obtenerGrupo(grupo.getIdGrupo())!=null){
                mav.setViewName("agregarGrupo");
                mav.addObject("errorGrupoExist","El grupo ya existe!, pruebe con otro código");
            }else{*/
                mav.setViewName("agregarGrupo");
                if(groupService.agregarGrupo(grupo)){
                    mav.addObject("alerta","exito");
                }
                else{
                    mav.addObject("alerta","error");
                }

           // }

        return mav;
    }
    @RequestMapping(value = "/Grupos/verificarGrupo.do",method = RequestMethod.POST ,produces = "application/json")
    @ResponseBody public boolean verificarIdGrupo(@RequestBody String idGrupo){
        groupService=new GrupoService();
        if(groupService.verificarGrupo(idGrupo)){
            return true; //no existe el grupo
        }
        else{
            return false; //hay un grupo con el mismo código
        }
    }


}
