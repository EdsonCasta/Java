package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.EjemploStreams;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primer proyecto Spring sin Web");
		principal.mostrarElMenu();

		/*
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos( "https://www.omdbapi.com/?t=game+of+thrones&apikey=2d783b4f");
		System.out.println(json);

		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);

		json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=2d783b4f");
		DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println(episodio);
		*/

//		EjemploStreams ejemploStreams = new EjemploStreams();
//		ejemploStreams.muestraEjamplo();
	}
}
