package com.Formatters;

import com.model.Grupo;
import com.services.GrupoService;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by Jacobo on 26/02/2015.
 */
@Component
public class FormatterGrupo implements Formatter<Grupo> {

    @Override
    public String print(Grupo grupo, Locale locale) {
        return grupo.toString();
    }

    @Override
    public Grupo parse(String idGrupo, Locale locale) throws ParseException {
        GrupoService grupoService =  new GrupoService();

        Grupo grupo =  grupoService.obtenerGrupo(idGrupo);

        return grupo;
    }
}
