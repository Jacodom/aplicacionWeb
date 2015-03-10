package com.Formatters;

import com.model.Formulario;
import com.services.FormularioService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Jacobo on 10/03/2015.
 */
public class FormatterFormulario implements Formatter<Formulario> {

    @Override
    public String print(Formulario formulario, Locale locale) {
        return formulario.toString();
    }

    @Override
    public Formulario parse(String idFormulario, Locale locale) throws ParseException {
        FormularioService formularioService =  new FormularioService();

        Formulario formulario =  formularioService.obtenerFormulario(idFormulario);

        return formulario;
    }
}
