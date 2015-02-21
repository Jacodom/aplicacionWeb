package com.helpers;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Jacobo on 19/02/2015.
 */
public class EmailSender {

    public boolean enviarMail(String from,String to, String asunto, String contenido){

        final String username="modulo.seguridad.uai@gmail.com";
        final String password="mailuai123";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(from));
            mensaje.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            mensaje.setSubject(asunto);
            mensaje.setContent(contenido,"text/html");

            Transport.send(mensaje);

            System.out.println("se mandooooooooooo monoooo");
            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
