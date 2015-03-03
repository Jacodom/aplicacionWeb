package aplicacionWeb;

import com.model.Usuario;
import com.services.SeguridadService;
import com.services.UsuarioService;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Jacobo on 18/02/2015.
 */
public class testEncriptar {

   public static void main(String args[]) throws Exception {
       UsuarioService usuarioService = new UsuarioService();
       SeguridadService seguridadService = new SeguridadService();
       Usuario user = usuarioService.obtenerUsuario("hernan");

       user.setClaveUsuario("1234");
       user.setClaveUsuario(seguridadService.encriptarPassword(user.getClaveUsuario()));

       usuarioService.modificarUsuario(user);

       System.out.println("clave:"+ user.getClaveUsuario());
   }


}
