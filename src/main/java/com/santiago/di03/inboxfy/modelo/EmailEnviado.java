package com.santiago.di03.inboxfy.modelo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.BodyPart;
import java.io.IOException;
import java.util.ArrayList;

public class EmailEnviado extends Email {
    private ArrayList<MimeBodyPart> adjuntos;

    public EmailEnviado(String asunto, String contenido, String destinatario, String remitente, ArrayList<MimeBodyPart> adjunto) {
        super(asunto, contenido, destinatario, remitente);
        this.adjuntos = adjunto;
    }

    public EmailEnviado() {
        super();
        this.adjuntos = null;
    }

    public MimeBodyPart getAdjunto(int indice) {
        return adjuntos.get(indice);
    }

    private boolean esAdjunto(BodyPart bodyPart) throws MessagingException {
        // Verificar si tiene disposición "attachment"
        String disposicion = bodyPart.getDisposition();
        if (disposicion != null && (disposicion.equalsIgnoreCase(BodyPart.ATTACHMENT) || disposicion.equalsIgnoreCase(BodyPart.INLINE))) {
            return true;
        }

        // Verificar si tiene tipo de contenido que generalmente indica un archivo adjunto
        String tipoContenido = bodyPart.getContentType();
        if (tipoContenido != null && tipoContenido.toLowerCase().startsWith("application/")) {
            return true;
        }

        return false;
    }

    public void addFicheroAdjunto(String ruta) throws MessagingException, IOException {
        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.attachFile(ruta);
        this.adjuntos.add(adjunto);
    }

    public void addFicheroAdjunto(MimeBodyPart adjunto) throws MessagingException, IOException {
        this.adjuntos.add(adjunto);
    }

    public void removeFicheroAdjunto(int indice) {
        this.adjuntos.remove(indice);
    }

    public void removeFicheroAdjunto(MimeBodyPart adjunto) {
        this.adjuntos.remove(adjunto);
    }

    public void removeFicheroAdjunto(String nombre) throws MessagingException {
        for (MimeBodyPart adjunto : this.adjuntos) {
            if (adjunto.getFileName().equals(nombre)) {
                this.adjuntos.remove(adjunto);
                break;
            }
        }
    }

    public void clearFicherosAdjuntos() {
        this.adjuntos.clear();
    }

    public void sendEmail() {

    }
}
