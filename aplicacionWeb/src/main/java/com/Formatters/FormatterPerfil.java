package com.Formatters;

import com.model.Perfil;
import com.services.PerfilService;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

import java.util.Locale;

/**
 * Created by Jacobo on 10/03/2015.
 */
public class FormatterPerfil implements Formatter<Perfil> {

    @Override
    public String print(Perfil perfil, Locale locale) {
        return perfil.toString();
    }

    @Override
    public Perfil parse(String idPerfil, Locale locale) throws ParseException {
        PerfilService perfilService =  new PerfilService();

        Perfil perfil =  perfilService.obtenerPerfil(Integer.parseInt(idPerfil));

        return perfil;
    }
}
