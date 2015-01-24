package aplicacionWeb;

import com.model.Usuario;
import com.services.UsuarioService;

/**
 * Created by Jacobo on 22/01/2015.
 */
public class pruebaDB {

    public static void main(String[] args) throws Exception{
        UsuarioService userService = new UsuarioService();
        Usuario user1= new Usuario();

        user1.setClaveUsuario("1234");
        user1.setEmailUsuario("dominguezjaco@gmail.com");
        user1.setEstadoUsuario(true);
        user1.setIdUsuario("jacodom");
        user1.setNombreUsuario("Jacobo Dominguez");

        try{
            userService.agregarUsuario(user1);
            System.out.println("correcto!");
        }catch(Exception ex){
            throw new Exception("Error!",ex);
        }


    }
}
