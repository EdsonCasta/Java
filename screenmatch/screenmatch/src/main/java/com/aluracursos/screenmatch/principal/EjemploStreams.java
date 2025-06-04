package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjamplo (){
        List<String> nombres = Arrays.asList("Thiago", "Emiliano", "Sindy", "Edson");
        nombres.stream()
                .sorted()
                .limit(1)
                .filter(n -> n.startsWith("E"))
                .map(n -> n.toLowerCase())
                .forEach(System.out::println);
    }
}
