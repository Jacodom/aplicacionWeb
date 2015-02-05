package aplicacionWeb;

import com.dao.DaoGrupo;
import com.model.Grupo;
import com.model.Usuario;
import com.services.UsuarioService;
import org.apache.commons.collections.set.UnmodifiableSet;

import java.util.List;
import java.util.Set;

/**
 * Created by Jacobo on 05/02/2015.
 */
public class formulariosTest {

    public static void main(String[] args) throws Exception{

        Grupo grupo1 = new Grupo();

        grupo1.setIdGrupo("ADM");
        grupo1.setDescripcionGrupo("ADMINISTRADORES");
        grupo1.setEstadoGrupo(true);

        UsuarioService userService = new UsuarioService();
        Usuario user = userService.obtenerUsuario("jacodom");

        grupo1.addUsuario(user);


        DaoGrupo daoGrupo = new DaoGrupo();

        daoGrupo.agregar(grupo1);
        userService.modificarUsuario(user);

        for (Grupo grup : daoGrupo.obtener())
        {
            System.out.println(grup.getDescripcionGrupo());

        }

        for(Grupo grupon : userService.obtenerGruposUsuario(user)){
            System.out.println(grupon.getIdGrupo());
        }
    }
}
