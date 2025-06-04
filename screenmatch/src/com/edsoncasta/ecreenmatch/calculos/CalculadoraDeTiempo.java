package com.edsoncasta.ecreenmatch.calculos;

import com.edsoncasta.screenmatch.modelos.Pelicula;
import com.edsoncasta.screenmatch.modelos.Serie;
import com.edsoncasta.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

//    public void incluye(Pelicula pelicula){
//        tiempoTotal += pelicula.getDuracionEnMinutos();
//    }
//
//    public void incluye(Serie serie){
//        tiempoTotal += serie.getDuracionEnMinutos();
//    }

    public void incluye(Titulo titulo){
        System.out.println("Agregando duración en minutos de " + titulo);
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }
}
