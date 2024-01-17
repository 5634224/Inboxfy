package com.santiago.di03.inboxfy.modelo;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.IOException;

public class Email {
    private String asunto;
    private String contenido;
    private String destinatario;
    private String remitente;

    public Email(String asunto, String contenido, String destinatario, String remitente) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.destinatario = destinatario;
        this.remitente = remitente;
    }

    public Email(Email email) {
        this(email.asunto, email.contenido, email.destinatario, email.remitente);
    }

    public Email(Message mensaje) throws MessagingException, IOException {
        this(mensaje.getSubject(), mensaje.getContent().toString(), mensaje.getRecipients(Message.RecipientType.TO)[0].toString(), mensaje.getFrom()[0].toString());
    }

    public Email() {
        this("", "", "", "");
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        if (!this.asunto.equals(asunto)) {
            this.asunto = asunto;
        }
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        if (!this.contenido.equals(contenido)) {
            this.contenido = contenido;
        }
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        if (!this.destinatario.equals(destinatario)) {
            this.destinatario = destinatario;
        }
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        if (!this.remitente.equals(remitente)) {
            this.remitente = remitente;
        }
    }
}