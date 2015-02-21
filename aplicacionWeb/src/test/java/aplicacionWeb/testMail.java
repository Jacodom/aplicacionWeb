package aplicacionWeb;

import com.model.Usuario;
import com.services.EmailService;

/**
 * Created by Jacobo on 19/02/2015.
 */
public class testMail {

    public static void main(String args[]) throws Exception {
        EmailService emailService =  new EmailService();
        Usuario usuario = new Usuario();
        usuario.setEmailUsuario("dominguezjaco@gmail.com");
        usuario.setIdUsuario("jacobito");
        usuario.setClaveUsuario("1234");
        usuario.setNombreUsuario("jacobo dominguez");

        if(emailService.enviarEmail(usuario,"modulo.seguridad.uai@gmail.com",usuario.getEmailUsuario(),"testing","","generar_clave")){
            System.out.println("se mando!!");
        }
    }
}
