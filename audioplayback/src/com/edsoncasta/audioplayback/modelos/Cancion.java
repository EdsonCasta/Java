package com.edsoncasta.audioplayback.modelos;

public class Cancion extends Audio {

    private String albun;
    private String Cantante;
    private String genero;

    @Override
    public int getClasificacion() {
        if (getMeGusta() > 5000){
            return 10;
        } else {
            return 5;
        }
    }

    public String getAlbun() {
        return albun;
    }

    public void setAlbun(String albun) {
        this.albun = albun;
    }

    public String getCantante() {
        return Cantante;
    }

    public void setCantante(String cantante) {
        Cantante = cantante;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
