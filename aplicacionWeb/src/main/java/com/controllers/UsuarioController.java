package com.controllers;

import com.helpers.ConstructorVistaHelper;
import com.model.Grupo;
import com.model.Usuario;
import com.model.UsuarioCambioPassword;
import com.services.EmailService;
import com.services.GrupoService;
import com.services.SeguridadService;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.SessionAttributesHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jacobo on 25/10/14.
 */


@Controller
@SessionAttributes("usuarioSession")
public class UsuarioController {

    private UsuarioService userService;

    @RequestMapping(value = "/Usuarios/usuario",method = RequestMethod.GET)
    public ModelAndView mostrarPagina(@ModelAttribute("usuarioSession") Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"usuario",usuarioSession);
        return mav;
    }

    public ModelAndView setearVista(ModelAndView vista, String nombreVista, Usuario user){
        userService = new UsuarioService();
        vista.setViewName(nombreVista);
        vista.addObject("modulosUsuario",userService.obtenerModulosUsuario(user));
        vista.addObject("perfilesUsuario", userService.obtenerPerfilesUsuario(user));

        return vista;
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

    @RequestMapping(value = "/Usuarios/agregarUsuario",method = RequestMethod.GET)
    public ModelAndView agregarUsuarioGet(@ModelAttribute("usuario")Usuario usuario,
                                 @ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"agregarUsuario",usuarioSession);
        return mav;
    }

    @RequestMapping(value = "/Usuarios/addUsuario.do",method = RequestMethod.POST)
    @ResponseBody public boolean agregarUsuarioPost(@RequestBody Usuario usuario) throws Exception {
        userService=new UsuarioService();
        SeguridadService seguridadService = new SeguridadService();
        EmailService emailService = new EmailService();

        String claveUsuario = seguridadService.generarClave();
        usuario.setClaveUsuario(seguridadService.encriptarPassword(claveUsuario));

        if (userService.agregarUsuario(usuario)){
            usuario.setClaveUsuario(claveUsuario);
            if(emailService.enviarEmail(usuario,"modulo.seguridad.uai@gmail.com",usuario.getEmailUsuario(),"Nuevo usuario","","nuevo_usuario")){
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    @RequestMapping(value = "/Usuarios/consultarUsuarios.do",method = RequestMethod.GET)
    public ModelAndView consultarUsuarios(@ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"usuarios",usuarioSession);
        userService = new UsuarioService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(userService.obtenerUsuarios().size(), 10);

        mav.addObject("cantPaginas", cantP);
        mav.addObject("accion","C");

        return mav;
    }

    @RequestMapping(value = "/Usuarios/recuperarPassword.do",method = RequestMethod.GET)
    public ModelAndView mostrarRecuperarPassword(@ModelAttribute("usuarioRecup")Usuario usuarioRecup){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recuperarPassword");

        return mav;
    }

    @RequestMapping(value = "/Usuarios/recuperarPassword.do",method = RequestMethod.POST)
    public @ResponseBody boolean recuperarPassword(@RequestBody Usuario usuarioRecup) throws Exception {
        UsuarioService usuarioService = new UsuarioService();
        SeguridadService seguridadService = new SeguridadService();
        EmailService emailService = new EmailService();


        Usuario userBD = usuarioService.obtenerUsuario(usuarioRecup.getIdUsuario());

        if(userBD!=null){
            if(userBD.getEmailUsuario().equals(usuarioRecup.getEmailUsuario())){
                String nuevaPassword = seguridadService.generarClave();
                userBD.setClaveUsuario(seguridadService.encriptarPassword(nuevaPassword));
                if(usuarioService.modificarUsuario(userBD)){
                    userBD.setClaveUsuario(nuevaPassword);
                    if(emailService.enviarEmail(userBD,"modulo.seguridad.uai@gmail.com",userBD.getEmailUsuario(),"Generación de nueva clave","","generar_clave")){
                        return true;
                    }else{
                        //no se pudo mandar el mail
                        return false;
                    }
                }else{
                    //no se pudo guardar la nueva password
                    return false;
                }

            }else{
                //no coinciden los datos ingresados
                return false;
            }
        }else{
            //no existe el user solicitado
            return false;
        }
    }

    @RequestMapping(value = "/Usuarios/cambiarPassword.do",method = RequestMethod.GET)
    public ModelAndView mostrarCambiarPassword(@ModelAttribute("usuarioCambioPw")UsuarioCambioPassword usuarioCambioPw,
                                               HttpSession session){ //agrego un usuario de tipo
                                                                    //cambioUsuario para no sobreescribir la sesion
                                                                   //y usarlo en el form de la pag .jsp
        Usuario usuarioSession = (Usuario) session.getAttribute("usuarioSession"); //obtengo el usuario de la session
        ModelAndView mav = setearVista(new ModelAndView(), "cambiarPassword", usuarioSession);
        return mav;
    }

    @RequestMapping(value = "/Usuarios/cambiarPassword.do", method = RequestMethod.POST)
    public ModelAndView cambiarPassword(@ModelAttribute("usuarioCambioPw") UsuarioCambioPassword usuarioCambioPw,
                                  HttpSession session) throws Exception {
        userService = new UsuarioService();
        SeguridadService seguridadService = new SeguridadService();


        Usuario usuarioSession = (Usuario) session.getAttribute("usuarioSession"); //obtengo el usuario de la session

        //se crea la vista a retornar(la misma del form) y se le agrega el usuarioSession para la barra de navegacion
        ModelAndView mav = setearVista(new ModelAndView(),"cambiarPassword",usuarioSession);

        //comparo la clave de la sesion actual con la contraseña anterior ingresada en el form (se encripta)
        if(usuarioSession.getClaveUsuario().equals(seguridadService.encriptarPassword(usuarioCambioPw.getPasswordAnterior()))){
            //se le settea la nueva contraseña al usuario
            usuarioSession.setClaveUsuario(seguridadService.encriptarPassword(usuarioCambioPw.getPasswordNueva()));

            //se guardan los datos y en base a eso las alertas
            if(userService.modificarUsuario(usuarioSession)){
                mav.addObject("alerta","exito");
            }else{
                mav.addObject("alerta","error");
            }
        }else{
            mav.addObject("errorPassword","La contraseña ingresada no coindice con la almacenada en la base de datos. ");
        }

        return mav;
    }

    @RequestMapping(value = "/Usuarios/ajax/usuarios.do",method = RequestMethod.GET)
    public String usuariosPagina(Model model, @RequestParam("pg")int pg,
                                 @RequestParam("accion")String accion){
        userService = new UsuarioService();

        List<Usuario> listaUsuarios = userService.obtenerUsuariosPorPagina(pg,10);

        model.addAttribute("listaUsuarios",listaUsuarios);
        model.addAttribute("accion",accion);

        return "/ajax/usuarios";

    }

    @RequestMapping(value = "/Usuarios/ajax/usuario.do",method = RequestMethod.GET)
    public String detallesUsuario(Model model,@RequestParam("idUsuario")String idUsuario,
                                  @RequestParam("accion")String accion){
        userService = new UsuarioService();
        GrupoService grupoService = new GrupoService();

        Usuario user = userService.obtenerUsuario(idUsuario);
        List<Grupo>listaGruposUser =  userService.obtenerGruposUsuario(user);

        //user.setGrupos(null);

        model.addAttribute("usuarioDetalles",user);
        model.addAttribute("listaGruposUser",listaGruposUser);
        model.addAttribute("accion",accion);

        if(accion.equals("M")){

            List<Grupo> gruposTodos = grupoService.obtenerGrupos();
            for(Grupo grupoU : listaGruposUser){
                for(Grupo grupo : grupoService.obtenerGrupos()){
                    if(grupo.getIdGrupo().equals(grupoU.getIdGrupo())){
                        gruposTodos.remove(grupo);
                    }
                }
            }

            model.addAttribute("gruposTodos",gruposTodos);
        }

        return "ajax/usuario";
    }

    @RequestMapping(value = "/Usuarios/modificarUsuario.do",method = RequestMethod.GET)
    public ModelAndView modificarUsuarioGet(@ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"usuarios",usuarioSession);
        userService = new UsuarioService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(userService.obtenerUsuarios().size(), 10);

        mav.addObject("cantPaginas", cantP);
        mav.addObject("accion", "M");

        return mav;
    }

    @RequestMapping(value = "/Usuarios/modificarUsuario.do",method = RequestMethod.POST)
    public ModelAndView modificarUsuarioPost(@ModelAttribute("usuarioDetalles") Usuario usuarioMod,
                                             HttpSession session) throws Exception {
        userService = new UsuarioService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();
        Usuario userS = (Usuario) session.getAttribute("usuarioSession");
        usuarioMod.setClaveUsuario(userService.obtenerUsuario(usuarioMod.getIdUsuario()).getClaveUsuario());
        ModelAndView mav = setearVista(new ModelAndView(), "usuarios", userS);
        int cantP = cHelper.obtenerCantidadPaginas(userService.obtenerUsuarios().size(),10);

        mav.addObject("cantPaginas",cantP);
        mav.addObject("accion","M");

        if(userService.modificarUsuario(usuarioMod)){
            mav.addObject("alerta","exito");
            }else{
                mav.addObject("alerta","error");
            }


        return mav;
    }

    @RequestMapping(value = "/Usuarios/eliminarUsuario.do",method = RequestMethod.GET)
    public ModelAndView eliminarUsuarioGet(@ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"usuarios",usuarioSession);
        userService = new UsuarioService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(userService.obtenerUsuarios().size(),10);

        mav.addObject("cantPaginas",cantP);
        mav.addObject("accion","B");

        return mav;
    }

    @RequestMapping(value = "/Usuarios/eliminarUsuario.do",method = RequestMethod.POST)
    @ResponseBody public boolean eliminarUsuarioPost(@RequestBody String idUsuario) throws Exception {
        userService = new UsuarioService();

        Usuario user = userService.obtenerUsuario(idUsuario);

        if(userService.eliminarUsuario(user)){
            return true;
        }else{
            return false;
        }
    }
}
