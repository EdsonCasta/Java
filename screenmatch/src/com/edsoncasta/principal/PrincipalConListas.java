package com.edsoncasta.principal;

import com.edsoncasta.screenmatch.modelos.Pelicula;
import com.edsoncasta.screenmatch.modelos.Serie;
import com.edsoncasta.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {

    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Transformes", 2022);
        miPelicula.evalua(8);
        Pelicula otraPelicula = new Pelicula("Busqueda Implacable", 2014);
        otraPelicula.evalua(7);
        var sonic = new Pelicula("Sonic 3", 2024);
        sonic.evalua(9);
        Serie RapidoFurioso = new Serie("Rapido y furiosos", 2018);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(sonic);
        lista.add(RapidoFurioso);

        for(Titulo item: lista){
            System.out.println("Nombre: " + item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println(pelicula.getClasificacion());
            }
        }

        Collections.sort(lista);
        System.out.println();
        System.out.println("Lista de titulos ordenada:\n" + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaLanzamiento));
        System.out.println();
        System.out.println("Lista ordenada fecha de lanzamiento:\n" + lista);
    }
}
