package aplicacionWeb;

import com.dao.DaoGrupo;
import com.dao.DaoPerfil;
import com.model.*;
import com.services.FormularioService;
import com.services.GrupoService;
import com.services.ModuloService;
import com.services.UsuarioService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import sun.misc.Perf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacobo on 10/02/2015.
 */
public class testBusquedasAvanzadas {

    public static void main(String args[]) throws Exception {
        UsuarioService userService = new UsuarioService();
        Usuario usuario = userService.obtenerUsuario("jacodom");
        GrupoService grupoService = new GrupoService();
        ModuloService moduloService = new ModuloService();
        FormularioService formularioService = new FormularioService();
        DaoPerfil daoPerfil = new DaoPerfil();

        //se agregan las entidades a la BD
//        Formulario form = new Formulario();
//        form.setIdFormulario("formAgregarUsuario");
//        form.setEstadoFormulario(true);
//        form.setDescripcionFormulario("Agregar Usuario");
//        form.setNombreFormulario("agregarUsuario");
//        form.setModulo(moduloService.obtenerModulo("USRS"));
//        if(formularioService.AgregarFormulario(form)){
//            System.out.println("form agregado!");
//        }



        /*Perfil perfil = new Perfil();
        perfil.setFormulario(form);
        perfil.setGrupo(grupoService.obtenerGrupo("ADM"));
        daoPerfil.agregar(perfil);*/


        List<Grupo> listaGrupos = userService.obtenerGruposUsuario(usuario);
        List<Perfil> listaPerfiles = userService.obtenerPerfilesUsuario(usuario);
        List<Modulo> listaModulos = userService.obtenerModulosUsuario(usuario);

        System.out.println(usuario.getNombreUsuario());
        System.out.println("Datos perfil: ");

        for(Perfil perfil1 : listaPerfiles){
            System.out.println(perfil1.getIdPerfil()+"    "+perfil1.getFormulario().getDescripcionFormulario()+"    "+perfil1.getFormulario().getModulo().getDescripcionModulo());
        }

        System.out.println("Datos Modulos:");
        for(Modulo modulo : listaModulos){
            System.out.println(modulo.getIdModulo()+"    "+modulo.getDescripcionModulo());
        }

    }
}
