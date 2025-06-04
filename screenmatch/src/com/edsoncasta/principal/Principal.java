package com.edsoncasta.principal;

import com.edsoncasta.ecreenmatch.calculos.CalculadoraDeTiempo;
import com.edsoncasta.ecreenmatch.calculos.FiltroRecomendacion;
import com.edsoncasta.screenmatch.modelos.Episodio;
import com.edsoncasta.screenmatch.modelos.Serie;
import com.edsoncasta.screenmatch.modelos.Pelicula;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Transformes", 2022);
        miPelicula.setDuracionEnMinutos(135);
        miPelicula.setIncluidoEnElPlan(true);
        miPelicula.muestraFichaTecnica();

        miPelicula.evalua(7.8);
        miPelicula.evalua(10);
        miPelicula.evalua(9.5);

        Serie RapidoFurioso = new Serie("Rapido y furiosos", 2018);
        RapidoFurioso.setTemporadas(1);
        RapidoFurioso.setMinutosPorEpisodio(45);
        RapidoFurioso.setEpisodiosTemporada(8);
        RapidoFurioso.muestraFichaTecnica();

        //System.out.println(RapidoFurioso.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Busqueda Implacable", 2014);
        otraPelicula.setDuracionEnMinutos(125);
        otraPelicula.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(RapidoFurioso);
        calculadora.incluye(otraPelicula);

        System.out.println("\nCantidad de calificaciones peliculas y series: " + miPelicula.getTotalDeLasEvaluaciones());
        System.out.println("\nCalificacion promedio: " + miPelicula.calculaMedia());
        System.out.println("\nTiempo total para poder ver todas la peliculas y series: " + calculadora.getTiempoTotal());
        System.out.println();

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("Mas Rapido");
        episodio.setSerie(RapidoFurioso);
        episodio.setTotalVisualizaciones(101);
        filtroRecomendacion.filtra(episodio);

        var sonic = new Pelicula("Sonic 3", 2024);
        sonic.setFechaLanzamiento(2024);

        ArrayList<Pelicula> listaDePelicula = new ArrayList<>();
        listaDePelicula.add(miPelicula);
        listaDePelicula.add(otraPelicula);
        listaDePelicula.add(sonic);

        System.out.println("Tamaño de la lista: " + listaDePelicula.size());
        System.out.println("La primera pelicula es: " + listaDePelicula.get(0).getNombre());
        System.out.println(listaDePelicula);
        System.out.println("toString de la pelicula: " + listaDePelicula.get(0).toString());
    }
}
