package com.controllers;

import com.helpers.ConstructorVistaHelper;
import com.model.Usuario;
import com.services.EmailService;
import com.services.SeguridadService;
import com.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView agregarUsuario(@ModelAttribute("usuario")Usuario usuario,
                                 @ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"agregarUsuario",usuarioSession);
        return mav;
    }

    @RequestMapping(value = "/Usuarios/addUsuario.do",method = RequestMethod.POST)
    public ModelAndView agregarUsuario(@ModelAttribute("usuario") Usuario usuario) throws Exception {
        userService=new UsuarioService();

        ModelAndView mav = new ModelAndView();


        if (userService.agregarUsuario(usuario)){
            mav.setViewName("usuarioAgregado");
            return mav;
        }else{
            mav.setViewName("errorAgregarUsuario");
            return mav;
        }
    }

    @RequestMapping(value = "/Usuarios/consultarUsuarios.do",method = RequestMethod.GET)
    public ModelAndView consultarUsuarios(@ModelAttribute("usuarioSession")Usuario usuarioSession){
        ModelAndView mav = setearVista(new ModelAndView(),"consultarUsuarios",usuarioSession);
        userService = new UsuarioService();
        ConstructorVistaHelper cHelper = new ConstructorVistaHelper();

        int cantP = cHelper.obtenerCantidadPaginas(userService.obtenerUsuarios().size(),10);

        mav.addObject("cantPaginas",cantP);

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

    @RequestMapping(value = "/Usuarios/ajax/usuarios.do",method = RequestMethod.GET)
    public String usuariosPagina(Model model, @RequestParam("pg")int pg){
        userService = new UsuarioService();

        List<Usuario> listaUsuarios = userService.obtenerUsuariosPorPagina(pg,10);

        model.addAttribute("listaUsuarios",listaUsuarios);

        return "/ajax/usuarios";

    }

    @RequestMapping(value = "/Usuarios/ajax/usuario.do",method = RequestMethod.GET)
    public String detallesUsuario(Model model,@RequestParam("idUsuario")String idUsuario){
        userService = new UsuarioService();

        Usuario user = userService.obtenerUsuario(idUsuario);

        model.addAttribute("usuarioDetalles",user);

        return "ajax/usuario";
    }
}
