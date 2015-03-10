package com.controllers;

import com.helpers.ConstructorVistaHelper;
import com.model.Perfil;
import com.model.Usuario;
import com.services.FormularioService;
import com.services.GrupoService;
import com.services.PerfilService;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jacobo on 03/03/2015.
 */

@Controller
@SessionAttributes("usuarioSession")
public class PerfilController {

    private PerfilService perfilService;
    private UsuarioService usuarioService;

    public ModelAndView setearVista(ModelAndView vista,String nombreVista,Usuario user){
        usuarioService = new UsuarioService();
        vista.setViewName(nombreVista);
        vista.addObject("modulosUsuario",usuarioService.obtenerModulosUsuario(user));
        vista.addObject("perfilesUsuario", usuarioService.obtenerPerfilesUsuario(user));

        return vista;
    }

    @RequestMapping(value = "/Perfiles/consultarPerfiles.do",method = RequestMethod.GET)
    public ModelAndView consultarPerfilesGet(@ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"perfiles",usuarioSession);

        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        perfilService = new PerfilService();

        int cantP = cHelper.obtenerCantidadPaginas(perfilService.obtenerPerfiles().size(),10);

        mav.addObject("cantPaginas",cantP);
        mav.addObject("accion","C");

        return mav;
    }

    @RequestMapping(value = "/Perfiles/eliminarPerfiles.do",method = RequestMethod.GET)
    public ModelAndView eliminarPerfilesGet(@ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"perfiles",usuarioSession);

        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        perfilService = new PerfilService();

        int cantP = cHelper.obtenerCantidadPaginas(perfilService.obtenerPerfiles().size(),10);

        mav.addObject("cantPaginas",cantP);
        mav.addObject("accion","B");

        return mav;
    }

    @RequestMapping(value = "/Perfiles/eliminarPerfiles.do",method = RequestMethod.POST)
    @ResponseBody public boolean eliminarPerfilPost(@RequestBody String idPerfil){
        perfilService = new PerfilService();

        int id = Integer.parseInt(idPerfil);

        if(perfilService.eliminarPerfil(perfilService.obtenerPerfil(id))){
            return true;
        }else{
            return false;
        }
    }

    @RequestMapping(value = "/Perfiles/ajax/perfiles.do",method = RequestMethod.GET)
    public String usuariosPagina(Model model, @RequestParam("pg")int pg,
                                 @RequestParam("accion")String accion){
        perfilService = new PerfilService();

        List<Perfil> listaPerfiles = perfilService.obtenerPerfilesPorPagina(pg, 10);

        model.addAttribute("listaPerfiles",listaPerfiles);
        model.addAttribute("accion",accion);

        return "/ajax/perfiles";

    }

    @RequestMapping(value = "/Perfiles/ajax/perfil.do",method = RequestMethod.GET)
    public String detallesUsuario(Model model,@RequestParam("idPerfil")int idPerfil,
                                  @RequestParam("accion")String accion) throws Exception {
        perfilService = new PerfilService();
        GrupoService grupoService = new GrupoService();

        Perfil perfil = perfilService.obtenerPerfil(idPerfil);
        List<Usuario> listaUsuariosGrupo =  grupoService.obtenerUsuariosGrupo(perfil.getGrupo());

        //user.setGrupos(null);

        model.addAttribute("perfilDetalles",perfil);
        model.addAttribute("listaUsuariosGrupo",listaUsuariosGrupo);
        model.addAttribute("accion",accion);

        return "ajax/perfil";
    }

    @RequestMapping(value = "/Perfiles/agregarPerfil.do",method = RequestMethod.GET)
    public ModelAndView agregarPerfilGet(@ModelAttribute("perfil")Perfil perfil,
                                         HttpSession session){
        ModelAndView mav = setearVista(new ModelAndView(),"agregarPerfil",(Usuario)session.getAttribute("usuarioSession"));

        GrupoService grupoService = new GrupoService();
        FormularioService formularioService = new FormularioService();

        mav.addObject("listaGrupos",grupoService.obtenerGrupos());
        mav.addObject("listaFormularios", formularioService.obtenerFormularios());

        return mav;
    }

    @RequestMapping(value = "/Perfiles/agregarPerfil.do",method = RequestMethod.POST)
    public ModelAndView agregarPerfilPost(@ModelAttribute("perfil")Perfil perfil,
                                          HttpSession session){
        ModelAndView mav = setearVista(new ModelAndView(),"agregarPerfil",(Usuario)session.getAttribute("usuarioSession"));

        perfilService = new PerfilService();

        GrupoService grupoService = new GrupoService();
        FormularioService formularioService = new FormularioService();

        mav.addObject("listaGrupos",grupoService.obtenerGrupos());
        mav.addObject("listaFormularios", formularioService.obtenerFormularios());

        if(perfilService.verificarPerfil(perfil)){
           mav.addObject("alerta","existe");
        }else{
            if(perfilService.agregarPerfil(perfil)){
                mav.addObject("alerta","exito");
            }else{
                mav.addObject("alerta","error");
            }
        }

        return mav;
    }
}
