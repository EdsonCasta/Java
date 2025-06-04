package com.edsoncasta.audioplayback.principal;

import com.edsoncasta.audioplayback.modelos.Cancion;
import com.edsoncasta.audioplayback.modelos.MiFavoritos;
import com.edsoncasta.audioplayback.modelos.Podcast;

public class Principal {

    public static void main(String[] args) {

        Cancion cancion = new Cancion();
        cancion.setTitulo("Bohemian Rhapsody");
        cancion.setCantante("Queen");

        Podcast podcast = new Podcast();
        podcast.setPesentador("Emiliano Castañeda");
        podcast.setTitulo("Hostorias Kids");

        for (int i = 0; i < 50; i++) {
            cancion.meGusta();
            podcast.meGusta();
        }

        for (int i = 0; i < 1000; i++) {
            cancion.reproducir();
            podcast.reproducir();
        }

        System.out.println("CANCIONES");
        System.out.println("Cantidad de reproducciones: " + cancion.getTotalDeReproducciones());
        System.out.println("Total Me Gusta: " + cancion.getMeGusta());
        System.out.println();
        System.out.println("PODCAST");
        System.out.println("Catidad de reproducciones: " + podcast.getTotalDeReproducciones());
        System.out.println("Total Me Gusta: " + podcast.getMeGusta());

        MiFavoritos miFavoritos = new MiFavoritos();
        miFavoritos.adicionar(podcast);
        miFavoritos.adicionar(cancion);
    }
}
