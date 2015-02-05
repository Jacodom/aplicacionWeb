package aplicacionWeb;

import com.model.Grupo;

import com.model.Usuario;
import com.services.GrupoService;
import com.services.UsuarioService;


/**
 * Created by Jacobo on 05/02/2015.
 */
public class formulariosTest {

    public static void main(String[] args) throws Exception{
        GrupoService grupoService = new GrupoService();
        Grupo grupo1 = grupoService.obtenerGrupo("ADM");

        for(Usuario user : grupoService.obtenerUsuariosGrupo(grupo1))
            System.out.println(user.getIdUsuario());

        UsuarioService usuarioService =  new UsuarioService();
        Usuario user1 = usuarioService.obtenerUsuario("jacodom");

        for(Grupo group : usuarioService.obtenerGruposUsuario(user1))
            System.out.println(group.getDescripcionGrupo());
    }
}
