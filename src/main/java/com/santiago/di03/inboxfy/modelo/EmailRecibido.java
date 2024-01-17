package com.santiago.di03.inboxfy.modelo;

public class EmailRecibido extends Email {
    private boolean leido;
    private boolean favorito;

    public EmailRecibido(String asunto, String contenido, String destinatario, String remitente, boolean leido, boolean favorito) {
        super(asunto, contenido, destinatario, remitente);
        this.leido = leido;
        this.favorito = favorito;
    }

    public EmailRecibido() {
        super();
        this.leido = false;
        this.favorito = false;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        if (leido != this.leido) {
            this.leido = leido;
        }
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        if (favorito != this.favorito) {
            this.favorito = favorito;
        }
    }

    @Override
    public String toString() {
        return getAsunto();
    }
}
