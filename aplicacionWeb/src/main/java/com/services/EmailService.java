package com.services;


import com.helpers.EmailSender;
import com.model.Usuario;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.view.WebappResourceLoader;

import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by Jacobo on 19/02/2015.
 */


public class EmailService {

    public boolean enviarEmail(Usuario usuario,String from, String to, String asunto, String contenido,String accion) throws Exception {
        try {
            EmailSender emailSender = new EmailSender();
            Properties p = new Properties();
            p.setProperty( "resource.loader", "class" );
            p.setProperty( "class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
            Velocity.init(p);
            if(accion.equals("generar_clave")){
                Template templateMail = Velocity.getTemplate("/velocity/templateGenerarClaveMail.vm","UTF-8");
                VelocityContext velocityContext = new VelocityContext();
                velocityContext.put("usuario",usuario);
                StringWriter stringWriter = new StringWriter();
                templateMail.merge(velocityContext,stringWriter);
                contenido = stringWriter.toString();
                emailSender.enviarMail(from, to, asunto, contenido);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }


}
