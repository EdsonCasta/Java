package com.edsoncasta.audioplayback.modelos;

public class MiFavoritos {

    public void adicionar(Audio audio){
        if (audio.getClasificacion() >= 8){
            System.out.println(audio.getTitulo() + " Uno de mis favoritos");
        } else {
            System.out.println(audio.getTitulo() + " Uno mas de mis favoritos");
        }
    }
}
