package com.edsoncasta.ecreenmatch.calculos;

public class FiltroRecomendacion {
    public void  filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Bien Evaluado");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Popular en el momento");
        } else {
            System.out.println("Coloca en la lista para ver luego");
        }
    };
}
