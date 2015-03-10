
/**
 * Created by pablo on 10/03/2015.
 */
package com.Formatters;
import com.model.Grupo;
import com.model.Usuario;
import com.services.GrupoService;
import com.services.UsuarioService;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class FormatterUsuario implements Formatter<Usuario> {

    @Override
    public String print(Usuario usuario, Locale locale) {
        return usuario.toString();
    }

    @Override
    public Usuario parse(String idUsuario, Locale locale) throws ParseException {
        UsuarioService usuarioService =  new UsuarioService();

        Usuario user = usuarioService.obtenerUsuario(idUsuario);

        return user;
    }
}

