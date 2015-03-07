package aplicacionWeb;

/**
 * Created by pablo on 10/02/2015.
 */
import com.dao.DaoUsuario;
import com.dao.DaoGrupo;
import com.model.Grupo;
import com.model.Usuario;
import com.services.GrupoService;
import com.services.SeguridadService;
import com.services.UsuarioService;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

public class aasa {

    	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


            UsuarioService usuarioService =  new UsuarioService();
            SeguridadService seguridadService = new SeguridadService();
            Usuario user = new Usuario();

            user.setNombreUsuario("Jacobo Dominguez");
            user.setEmailUsuario("dominguezjaco@gmail.com");
            user.setEstadoUsuario(true);
            user.setIdUsuario("jacodom");
            user.setClaveUsuario(seguridadService.encriptarPassword("asd123"));

            Grupo grupo =  new Grupo();
            grupo.setIdGrupo("ADM");
            grupo.setDescripcionGrupo("ADMINISTRADORES");
            grupo.setEstadoGrupo(true);

            grupo.addUsuario(user);

            GrupoService grupoService =  new GrupoService();
            grupoService.agregarGrupo(grupo);
    }

}
