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
import java.util.List;

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
    @RequestMapping(value = "/Grupos/ajax/grupos.do",method = RequestMethod.GET)
    public String gruposPagina(Model model, @RequestParam("pg")int pg,
                                 @RequestParam("accion")String accion){
        groupService = new GrupoService();

        List<Grupo> listaGrupos = groupService.obtenerGruposPorPagina(pg, 10);

        model.addAttribute("listaGrupos",listaGrupos); // lista a recorrer  <c:forEach var="grupo" items="${listaGrupos}">
        model.addAttribute("accion",accion);

        return "/ajax/grupos";

    }
    @RequestMapping(value = "/Grupos/ajax/grupo.do",method = RequestMethod.GET)
    public String detallesGrupo(Model model,@RequestParam("idGrupo")String idGrupo,
                                  @RequestParam("accion")String accion){
        groupService = new GrupoService();
        UsuarioService userService = new UsuarioService();

        Grupo group = groupService.obtenerGrupo(idGrupo);
        List<Usuario> listaUsuariosGrupo =  groupService.obtenerUsuariosGrupo(group);  // userService.obtenerGruposUsuario(user);

        //user.setGrupos(null);

        model.addAttribute("grupoDetalle",group);
        model.addAttribute("listaUsuariosGrupo",listaUsuariosGrupo); //ver variable
        model.addAttribute("accion",accion);

        if(accion.equals("M")){

            List<Usuario> usuarioTodos = userService.obtenerUsuarios();
            for(Usuario usu : listaUsuariosGrupo){
                for(Usuario user : userService.obtenerUsuarios()){
                    if(user.getIdUsuario().equals(usu.getIdUsuario())){
                        usuarioTodos.remove(user);
                    }
                }
            }

            model.addAttribute("usuariosTodos",usuarioTodos);
        }

        return "ajax/grupo";
    }
    @RequestMapping(value = "/Grupos/modificarGrupo.do",method = RequestMethod.GET)
    public ModelAndView modificarGrupoGet(@ModelAttribute("usuarioSession")Usuario usuarioSession) throws Exception {
        ModelAndView mav = setearVista(new ModelAndView(),"grupos",usuarioSession);
        groupService = new GrupoService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(groupService.obtenerGrupos().size(), 10);

        mav.addObject("cantPaginas", cantP);
        mav.addObject("accion", "M");

        return mav;
    }

    @RequestMapping(value = "/Grupos/consultarGrupo.do",method = RequestMethod.GET)
    public ModelAndView consultarGrupo(@ModelAttribute("usuarioSession")Usuario usuarioSession) throws Exception {
        ModelAndView mav = setearVista(new ModelAndView(),"grupos",usuarioSession);
        groupService = new GrupoService();

        //Paginación//
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(groupService.obtenerGrupos().size(), 10);

        mav.addObject("cantPaginas", cantP);
        mav.addObject("accion","C");

        return mav;
    }
    @RequestMapping(value = "/Grupos/eliminarGrupo.do",method = RequestMethod.GET)
    public ModelAndView eliminarGrupoGet(@ModelAttribute("usuarioSession")Usuario usuarioSession) throws Exception {
        ModelAndView mav = setearVista(new ModelAndView(),"grupos",usuarioSession);
        groupService = new GrupoService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(groupService.obtenerGrupos().size(),10);

        mav.addObject("cantPaginas",cantP);
        mav.addObject("accion","B");

        return mav;
    }
    @RequestMapping(value = "/Grupos/eliminarGrupo.do",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody public boolean eliminarGrupoPost(@RequestBody String idGrupo) throws Exception {

        groupService = new GrupoService();
        Grupo oGrupo = groupService.obtenerGrupo(idGrupo);

        if (groupService.eliminarGrupo(oGrupo)){
            return true;
        }else{
            return false;
        }
    }

}
