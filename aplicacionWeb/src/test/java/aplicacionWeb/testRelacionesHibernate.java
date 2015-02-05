package aplicacionWeb;

import com.dao.DaoGrupo;
import com.model.Grupo;
import com.model.Usuario;
import com.services.GrupoService;
import com.services.UsuarioService;

/**
 * Created by Jacobo on 05/02/2015.
 */
public class testRelacionesHibernate {

    public static void main(String[] args) throws Exception {
        UsuarioService userService =  new UsuarioService();
        Usuario user = userService.obtenerUsuario("jacodom");

        GrupoService grupoService = new GrupoService();
        DaoGrupo daoGrupo = new DaoGrupo();
        Grupo group = grupoService.obtenerGrupo("ADM");

        user.addGrupo(group);
        group.addUsuario(user);
        daoGrupo.modificar(group);
    }
}
