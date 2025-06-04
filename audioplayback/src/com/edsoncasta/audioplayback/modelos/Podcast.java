package com.edsoncasta.audioplayback.modelos;

public class Podcast extends Audio {

    private String pesentador;
    private String descripcion;

    @Override
    public int getClasificacion() {
        if (getTotalDeReproducciones() >= 2000){
            return 8;
        } else {
            return 2;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPesentador() {
        return pesentador;
    }

    public void setPesentador(String pesentador) {
        this.pesentador = pesentador;
    }
}
